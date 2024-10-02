package com.example.examen

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.examen.ui.theme.ExamenTheme
import retrofit2.Retrofit
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GitUi(modifier=Modifier.padding(innerPadding), context=context)
                }
            }
        }
    }
}

@Composable
fun GitUi(modifier: Modifier=Modifier, context: Context){
    val dataSource: MovieRemoteDataSource = MovieRemoteDataSource(
        RetrofitBuilder
    )
    val guestsPerFamily = listOf(2, 4, 1, 3)+
    var title by remember{mutableStateOf("")}
    var url by remember{mutableStateOf("")}
    val response=dataSource.getMovieInfo()
    LazyColumn {
        var index=0;
        while(index<response.results.size) {
            title=response.results[index].title
            url=response.results[index].path
            index=index+1
            AsyncImage(model=url, contentDescription=null)
            Text(text="$title")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExamenTheme {
        Greeting("Android")
    }
}