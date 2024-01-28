package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm() {
    var userName: String by remember { mutableStateOf("") }
    var passWord: String by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.login),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 24.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon"
                )
            },
            label = { Text(stringResource(R.string.username)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        PasswordField (
            password = passWord,
            onPasswordChange = { passWord = it },

        )
        Spacer(modifier = Modifier.height(16.dp))
        SubmitButton(
            onClick = {
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PasswordField(password: String, onPasswordChange: (String) -> Unit) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text(stringResource(R.string.password)) },
        trailingIcon = { Icon(Icons.Default.Lock, contentDescription = "Lock Icon") },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SubmitButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
    ) {
        Text(stringResource(R.string.submit))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormPreview() {
    LoginFormTheme {
        LoginForm()
    }
}