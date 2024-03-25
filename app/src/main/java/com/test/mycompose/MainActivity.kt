package com.test.mycompose

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.resolveDefaults
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.test.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    SimpleWidgetColumn()
                }
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SimpleWidgetColumn(){
    //竖向排列 可以查看参数列表查看更多 参数
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Row {
            //文本
            Text(
                text = "This is Text Big",//文字
                color = Color.Blue,//颜色
                fontSize = 26.sp)//大小

            //按钮 需要组合使用和Text
            val context= LocalContext.current
            Button(onClick = {
                Toast.makeText(context, "This is Toast", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "按钮", fontSize = 18.sp, color = Color.White)
            }
        }


        //输入框 文字输入刷新问题 State
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "这里相当于hint")
            })

              Image(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "A dog image"
        )

        AsyncImage(
            model = "https://img-blog.csdnimg.cn/20200401094829557.jpg",
            contentDescription = "First line of code",
            modifier= Modifier.wrapContentSize()
        )
        CircularProgressIndicator(
            color = Color.Green,
            strokeWidth = 6.dp
        )

        LinearProgressIndicator(
            color = Color.Blue
        )

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
    MyComposeTheme {
        Greeting("Android")
    }
}