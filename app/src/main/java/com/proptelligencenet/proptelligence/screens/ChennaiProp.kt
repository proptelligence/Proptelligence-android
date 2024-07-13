package com.proptelligencenet.proptelligence.screens

import PropertyItem
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.proptelligencenet.proptelligence.CircularProgressAnimated
import com.proptelligencenet.proptelligence.CustomDrawer
import com.proptelligencenet.proptelligence.CustomTopAppBar
import com.proptelligencenet.proptelligence.viewmodels.ChennaiViewModel

@Composable
fun ChennaiProp(navController: NavController) {
    val viewModel: ChennaiViewModel = viewModel()
    val chennaiProperties by viewModel.chennaiProperties.collectAsState()

    val timeoutOccurred by viewModel.timeoutOccurred.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()




    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val lifecycleOwner = LocalLifecycleOwner.current

    // Observe lifecycle events to refresh data when screen resumes
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME && !timeoutOccurred) {
                viewModel.refreshData()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    CustomDrawer(
        navController = navController,
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = { CustomTopAppBar(navController, coroutineScope, drawerState) },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
                    .padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Display error message with refresh option
                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                viewModel.refreshData()
                            }
                    )
                }

                // Show loading indicator or list of properties
                if (chennaiProperties == null && !timeoutOccurred) {
                    //Text(text = "Loading properties...", color = Color.Black)
                    CircularProgressAnimated()

                } else {
                    LazyColumn {
                        items(chennaiProperties ?: listOf()) { property ->
                            PropertyItem(property)
                        }
                    }
                }
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun ChennaiPropPreview() {
    ChennaiProp(rememberNavController())
}