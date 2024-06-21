package com.example.basictextfield

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basictextfield.ui.theme.BasicTextFieldTheme
import com.example.basictextfield.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicTextFieldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting()
                        Spacer(modifier = Modifier.height(16.dp))
                        GoogleButton(onClicked = {
                            Log.d("GoogleButton", "Clicked!")
                        })
                        Spacer(modifier = Modifier.height(4.dp))
                        FacebookButton(onClicked = {
                            Log.d("FacebookButton", "Clicked")
                        })
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember {
            mutableStateOf("Email")
        }
        var textPassword by remember {
            mutableStateOf("Password")
        }
        var textPhoneNumber by remember {
            mutableStateOf("Phone Number")
        }
        var textUserName by remember {
            mutableStateOf("User Name")
        }
        OutlinedTextField(value = text, onValueChange ={ newText ->
            text = newText
        },
            label = {
                Text(text = "Email")
            },
            singleLine = true,
            leadingIcon = {
               IconButton(onClick = { /*TODO*/ }) {
                   Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
               }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Done, contentDescription = "Done Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(value = textPassword, onValueChange = {newText1 ->
            textPassword = newText1
        },
            label = {
                Text(text = "Password")
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "Password Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Done, contentDescription = "Done Icon")
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            )
         )
        OutlinedTextField(value = textPhoneNumber, onValueChange = { numberText->
            textPhoneNumber = numberText
        },
            label = {
                Text(text = "Phone Number")
            },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Phone, contentDescription = "Leading Phone Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Done, contentDescription = "Trailing Done Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(value = textUserName, onValueChange = {userNameText->
            textUserName = userNameText
        },
            label = {
                Text(text = "UserName")
            },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Leading Icon of Person")
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Done, contentDescription = "Trailing Icon of Done")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )

    }
}


@Composable
fun GoogleButton(
    text: String = "Sign up with Google",
    loadingText: String = "Creating Account...",
    icon: Painter = painterResource(id = R.drawable.ic_google_logo),
    shapes: Shape = Shapes.medium,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    onClicked: () -> Unit
) {
    var clicked by remember {
        mutableStateOf(false)
    }
    Surface(
        onClick = {clicked = !clicked},
        shape = shapes,
        border = BorderStroke(width = 1.dp, color = borderColor),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(painter = icon,//painterResource(id = R.drawable.ic_google_logo) ,
                contentDescription = "Google Logo",
                tint = Color.Unspecified)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if(clicked) loadingText else text)
            if(clicked) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.primary
                )
                onClicked()
            }
        }
    }
}

@Composable
fun FacebookButton(
    text: String = "Sign up with Facebook",
    loadingText: String = "Creating Account",
    icon: Painter = painterResource(id = R.drawable.ic_google_logo),
    shapes: Shape = Shapes.medium,
    color: Color = MaterialTheme.colorScheme.surface,
    borderColor: Color = Color.LightGray,
    onClicked: () -> Unit
) {
var clicked by remember {
    mutableStateOf(false)
}
    Surface(onClick = {clicked = !clicked},
        shape = shapes,
        border = BorderStroke(width = 1.dp, color = borderColor),
        color = color

    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 8.dp,
                    top = 6.dp,
                    bottom = 6.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(painter =  icon ,
                    contentDescription = "Google Logo",
                    tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (clicked) loadingText else text)
            if(clicked) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.primary
                )
                onClicked()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicTextFieldTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting()
            Spacer(modifier = Modifier.height(16.dp))
            GoogleButton(onClicked = {
                Log.d("GoogleButton", "Clicked!")
            })
            Spacer(modifier = Modifier.height(4.dp))
            FacebookButton(onClicked = {
                Log.d("FacebookButton", "Clicked")
            })
        }

    }
}