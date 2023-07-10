/*▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

              - "NAVIGATION IN  JETPACK  COMPOSABLE" -



    ♦ The "NavController"
        → Keep "Track"
        → of the "Back Stack" of the "Composables"
        → and the "State" of "Each One"




    ♦ The "NavHost"
        → is Responsible for "Hosting" the "Content"
        → of the "NavDestination"



    ♦ The "NavGraphBuilder"
        → adds the "Destination" to the "NavGraph"

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀* */
package com.chivumarius.coursesapp



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chivumarius.coursesapp.ui.theme.CoursesAppTheme




class MainActivity : ComponentActivity() {

    // ♦ The "onCreate()" Method:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {

                // ►► TRANSPARENT SYSTEM BAR◄◄

                // ►► NAVIGATION SYSTEM ◄◄
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                ){

                    // (NAV-COMP. 1-1) "NAV CONTROLLER":
                    val navController = rememberNavController()


                    // (NAV-COMP. 1-2) "NAV HOST":
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                    ) {

                        // (NAV-COMP. 1-3) "NAV GRAPH BUILDER":

                        // -1- "HOME SCREEN":
                        composable(
                            route = "home"
                        ){
                            HomeScreen(
                                onDetailsClick = {
                                    /* ♦ "Navigation" to the "Details Screen"
                                            → in which we "Corresponding Pass" the "Chosen Course"
                                            → through "Arguments": */
                                    title -> navController.navigate("details/title=$title")
                                },


                                onAboutClick = {
                                    // ♦ "Navigation" to the "About Screen"
                                    navController.navigate("about")
                                },
                            )
                        }



                        // -2- "ABOUT SCREEN":
                        composable(
                            route = "about"
                        ){
                           AboutScreen (
                               // ♦ "Navigation Back" to the "Some Screen":
                               onNavigateUp = { navController.popBackStack() }
                           )
                        }



                        // -3- "DETAILS SCREEN":
                        composable(
                            route = "details/title={title}",
                            arguments = listOf(
                                navArgument("title"){
                                    type = NavType.StringType
                                    nullable = true
                                }
                            ),
                        ){

                            backStackEntry ->
                                val arguments = requireNotNull(backStackEntry.arguments)


                            // ♦ Getting the "Title":
                            val title = arguments.getString("title")



                            if (title != null) {

                                DetailsScreen(
                                    title = title,
                                    onNavigateUp = {
                                        navController.popBackStack()
                                    }
                                )

                            }
                        }

                    }
                }
            }
        }
    }
}




//▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
// ►► (1.1) "HOME SCREEN"  COMPOSABLE  FUNCTION  ◄◄
@Composable
fun HomeScreen(
    onDetailsClick: (title: String) -> Unit,
    onAboutClick: () -> Unit
) {

    Scaffold { padding ->
        LazyColumn(contentPadding = padding){

            // ♦ The "Home App Bar" Displayed in the "Columns":
            item {

               HomeAppBar (onAboutClick)
            }


            // ♦ The "Spaces" Between the "Home App Bar" and "Course Cards":
            item {
                Spacer ( modifier = Modifier.height(30.dp))
            }



            // ♦ The "Course Cards":
            items(allCourses){
                item ->
                CourseCard(
                    item,
                    onClick = {
                        onDetailsClick(item.title)
                    }
                )
            }

        }
    }
}





//▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
// ►► (1.2) "HOME APP BAR"  COMPOSABLE  FUNCTION  ◄◄
@Composable
private fun HomeAppBar( onAboutClick: () -> Unit ){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
    ) {

        Text(
            text = "My Udemy Courses",
            style = MaterialTheme.typography.h4
        )


        // ♦ Adding the "Spaces" Between:
        Spacer ( modifier = Modifier.weight(0.1f))


        // ♦ "Button":
        TextButton(onClick = onAboutClick) {
            Text(text = "About", fontSize = 24.sp)
        }
    }
}





//▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
// ►► (2) "COURSE CARDS"  COMPOSABLE  FUNCTION  ◄◄
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CourseCard(item: Courses, onClick: () -> Unit){
    Card(
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 10.dp
            )
            .fillMaxWidth(),
        onClick = onClick,
    ) {
        
        Column {
            Image(
                painterResource(item.thumbnail) ,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop,
            )
            
            
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(20.dp)
            ) {

                // ♦ Getting the "Title":
                Text(text = item.title)

                // ♦ Adding the "Spaces" Between:
                Spacer ( modifier = Modifier.height(8.dp))

                // ♦ Getting the "Body":
                Text(
                    text = item.body,
                    maxLines = 1,
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}





//▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
// ►► (3.1) "ABOUT SCREEN"  COMPOSABLE  FUNCTION  ◄◄
@Composable
fun AboutScreen(onNavigateUp: () -> Unit) { // ♦ "Unit" → returning Nothing.
    Scaffold {
        padding ->
        Column(Modifier.padding(padding)) {

            // ♦ Calling "AppBar()" Composable Function:
            AboutAppBar( title = "About", onNavigateUp )


            // ♦ Adding the "Spaces" Between:
            Spacer ( modifier = Modifier.height(20.dp))


            Column(Modifier.padding(16.dp)
            ) {

                // ♦ Getting the "Title":
                Text(text = "Tis ap is a demonstration " +
                        "about the navigation " +
                        "in Android Jetpack Compose")

                // ♦ Adding the "Spaces" Between:
                Spacer ( modifier = Modifier.height(20.dp))


                // ♦ Using "LocalUriHandler" → to "Open External Link"
                val udemyLink = LocalUriHandler.current
                Button(
                    onClick = {
                        udemyLink.openUri(
                            "https://www.udemy.com/course/the-complete-android-10-developer-course-mastering-android/"
                        )
                    }
                ) {
                    Text(text = "View Our Udemy Courses")
                }
            }
        }
    }
}





//▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
// ►► (3.2) "ABOUT APP BAR"  COMPOSABLE  FUNCTION  ◄◄
@Composable
fun AboutAppBar(title: String, onNavigateUp: () -> Unit){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
    ) {

        IconButton(onClick = onNavigateUp) {
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = "Go Back",
            )
        }  


        // ♦ Adding the "Spaces" Between:
        Spacer ( modifier = Modifier.width(10.dp))


        Text(text = title, fontSize = 24.sp)
    }
}





//▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
// ►► (4) "DETAILS SCREEN"  COMPOSABLE  FUNCTION  ◄◄
@Composable
fun DetailsScreen(
    title: String,
    onNavigateUp: () -> Unit
) {

    // ♦ Searching for the "Correct Course":
    val chosenCourse = allCourses.first { it.title == title }


    Scaffold {
            paddingValues ->
        Column(Modifier.padding(paddingValues)) {

           Row(
               verticalAlignment = Alignment.CenterVertically,
               modifier = Modifier.padding(vertical = 10.dp)
           ) {
                
              IconButton(onClick = onNavigateUp) {
                  Icon(
                      Icons.Rounded.ArrowBack,
                      contentDescription = "Go Back",
                  )
              }
           }
            
            
           Image(
               painterResource(id = chosenCourse.thumbnail),
               contentDescription = null,
               modifier = Modifier
                   .fillMaxWidth()
                   .aspectRatio(16f / 9f),
               contentScale = ContentScale.Crop // ► For Crop the Image and Filling → Inside the Image
           )


            // ♦ Adding the "Spaces" Between:
            Spacer( modifier = Modifier.height(20.dp))


            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {

                // ♦ Getting the "Title":
                Text(text = chosenCourse.title)

                // ♦ Adding the "Spaces" Between:
                Spacer ( modifier = Modifier.height(20.dp))

                // ♦ Getting the "Body":
                Text(
                    text = chosenCourse.body,
                    fontSize = 20.sp,
                )
            }
        }
    }
}
