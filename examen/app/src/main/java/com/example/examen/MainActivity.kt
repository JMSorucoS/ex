package com.example.examen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.examen.ui.theme.ExamenTheme
import retrofit2.Retrofit

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
funGitUi(modifier: Modifier=Modifier, context: Context){
    val dataSource: MovieRemoteDataSource = MovieRemoteDataSource(
        RetrofitBuilder
    )

    var title by remember{mutableStateOf("")}
    var url by remember{mutableStateOf("")}
    val response=dataSource.getMovieInfo()
    LazyColumn {
        items(100){
            title=response.title
            url=response.path
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