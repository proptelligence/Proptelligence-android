package com.proptelligencenet.proptelligence

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    navController: NavController,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState
) {
    TopAppBar(
        title = {
            Text(
                text = "Proptelligence",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(0.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch {
                    if (drawerState.isClosed) {
                        drawerState.open()
                    } else {
                        drawerState.close()
                    }
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon",
                    modifier = Modifier.padding(0.dp),
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate("cart") }) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Profile Icon",
                    modifier = Modifier.padding(0.dp),
                    tint = Color.White
                )
            }
            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile Icon",
                    modifier = Modifier.padding(0.dp),
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(android.graphics.Color.parseColor("#32357A"))),
    )
}


@Composable
fun CustomDrawer(
    navController: NavController,
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Add padding to the drawer content
            Column(modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxHeight()
                .width(250.dp)
                .background(Color.White)
            ) {

                Column(
                    modifier = Modifier
                        .background(Color(android.graphics.Color.parseColor("#32357A")))
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Proptelligence" , color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(16.dp))
                }

                Spacer(modifier = Modifier.height(20.dp))
                // Add your drawer items here
                NavigationDrawerItem(
                    label = { Text("Home") },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
                    selected = false,
                    modifier = Modifier
                        .padding(10.dp)
                        .border(0.5.dp, Color.Black, MaterialTheme.shapes.small),

                    onClick = {
                        navController.navigate("home")
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.White, // Background color when selected
                        unselectedContainerColor = Color.White, // Background color when unselected
                        selectedIconColor = Color.Black, // Icon color when selected
                        unselectedIconColor = Color.Black, // Icon color when unselected
                        selectedTextColor = Color.Black, // Text color when selected
                        unselectedTextColor = Color.Black // Text color when unselected
                    )
                )

                Spacer(modifier = Modifier.height(1.dp))
                NavigationDrawerItem(
                    label = { Text("Services") },
                    icon = { Icon(imageVector = Icons.Default.Build, contentDescription = "Services") },
                    selected = false,
                    modifier = Modifier
                        .padding(10.dp)
                        .border(0.5.dp, Color.Black, MaterialTheme.shapes.small),
                    onClick = {
                        navController.navigate("services")
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.White, // Background color when selected
                        unselectedContainerColor = Color.White, // Background color when unselected
                        selectedIconColor = Color.Black, // Icon color when selected
                        unselectedIconColor = Color.Black, // Icon color when unselected
                        selectedTextColor = Color.Black, // Text color when selected
                        unselectedTextColor = Color.Black // Text color when unselected
                    )
                )
                Spacer(modifier = Modifier.height(1.dp))
                NavigationDrawerItem(
                    label = { Text("Products") },
                    icon = { Icon(painter = painterResource(id = R.drawable.product), contentDescription = "products") },
                    selected = false,
                    modifier = Modifier
                        .padding(10.dp)
                        .border(0.5.dp, Color.Black, MaterialTheme.shapes.small),
                    onClick = {
                        navController.navigate("products")
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.White, // Background color when selected
                        unselectedContainerColor = Color.White, // Background color when unselected
                        selectedIconColor = Color.Black, // Icon color when selected
                        unselectedIconColor = Color.Black, // Icon color when unselected
                        selectedTextColor = Color.Black, // Text color when selected
                        unselectedTextColor = Color.Black // Text color when unselected
                    )
                )
                Spacer(modifier = Modifier.height(1.dp))
                NavigationDrawerItem(
                    label = { Text("Company") },
                    icon = { Icon(painter = painterResource(id = R.drawable.company), contentDescription = "company") },
                    selected = false,
                    modifier = Modifier
                        .padding(10.dp)
                        .border(0.5.dp, Color.Black, MaterialTheme.shapes.small),
                    onClick = {
                        navController.navigate("company")
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.White, // Background color when selected
                        unselectedContainerColor = Color.White, // Background color when unselected
                        selectedIconColor = Color.Black, // Icon color when selected
                        unselectedIconColor = Color.Black, // Icon color when unselected
                        selectedTextColor = Color.Black, // Text color when selected
                        unselectedTextColor = Color.Black // Text color when unselected
                    )
                )

                Spacer(modifier = Modifier.weight(0.9f))

                NavigationDrawerItem(
                    label = { Text("Sign Out", color = Color.Red) },
                    icon = { Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Sign Out") },
                    selected = false,
                    onClick = {
                        // Sign out the user
                        FirebaseAuth.getInstance().signOut()

                        // Navigate to the login screen
                        navController.navigate("login")
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.White, // Background color when selected
                        unselectedContainerColor = Color.White, // Background color when unselected
                        selectedIconColor = Color.Black, // Icon color when selected
                        unselectedIconColor = Color.Black, // Icon color when unselected
                        selectedTextColor = Color.Black, // Text color when selected
                        unselectedTextColor = Color.Black // Text color when unselected
                    )
                )

                Spacer(modifier = Modifier.weight(0.1f))

                // Add more items as needed
            }
        },
        content = content
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()

    CustomTopAppBar(
        navController = navController,
        coroutineScope = coroutineScope,
        drawerState = drawerState
    )
}

@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()

    CustomDrawer(
        navController = navController,
        drawerState = drawerState,
        content = {
            // Add your content here
            Column(modifier = Modifier
                .padding(top = 100.dp)
                .fillMaxSize()
                .background(Color.Black)) {
                // Add your drawer items here
                NavigationDrawerItem(
                    label = { Text("Home") },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
                    selected = false,
                    onClick = {
                        navController.navigate("home")
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Settings") },
                    icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings") },
                    selected = false,
                    onClick = {
                        navController.navigate("settings")
                    }
                )
                // Add more items as needed
            }
        }
    )
}
