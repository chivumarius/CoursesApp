package com.chivumarius.coursesapp

import androidx.annotation.DrawableRes


/* ►► The "Data" Class
        → will "Act" as a "Template"
        → for the "Courses Data".

        → It is "Used" to "Hold Data"
        → or "States"
        → and "Contains" the "Standard Functionalities" */
data class Courses(
    val rating: Float,
    val title: String,
    @DrawableRes val thumbnail: Int,  // ► This "Int" → will "Act" as a "Drawable"
    val body: String,
)



// ♦ Creating "Objects" → from "Courses()" Data Class:

// ►► "COURSE 1"  ◄◄
val course1 = Courses(
    rating = 4.5f,
    title = "The Complete Android 13 Developer Course - Build 52 Apps",
    R.drawable.course1,
    body = "Description\n" +
            "So you want to become an Android Developer & start publishing your apps?\n" +
            "\n" +
            "You like to stay home & learn from your own computer?\n" +
            "\n" +
            "You don't like to attend class?\n" +
            "\n" +
            "You need to learn about latest technology & app development?\n" +
            "\n" +
            "You have brilliant ideas & you need to develop them by creating your own apps by your hand?\n" +
            "\n" +
            "My name’s Abbass Masri, creator of the world’s best-selling Android Teaching app called: \"Master Android App\" … and I’ve designed The Complete Android 12 Developer Course, especially for YOU.",
)



// ►► "COURSE 2"  ◄◄
val course2 = Courses(
    rating = 4.5f,
    title = "Mastering Android App Development with Kotlin [XML +COMPOSE]",
    R.drawable.course2,
    body = "Description\n" +
            "So you want to become an Android developer and start publishing your own apps?\n" +
            "\n" +
            "Do you have no programming experience whatsoever? Or maybe you have worked with another programming language in the past?\n" +
            "\n" +
            "You came to the right place, where you'll master android app development from zero to hero through step-by-step explanations and well-crafted curriculum to take you with no or probably few coding skills to start creating professional android apps.\n" +
            "\n" +
            "You have a great idea for an app and you just need to learn how to make it happen? Or your friends know that you are tech-savvy and they constantly come to you with their great ideas and want you to build them?",
)



// ►► "COURSE 3"  ◄◄
val course3 = Courses(
    rating = 4.5f,
    title = "The Complete Java Developer Course -Mastering Java from zero",
    R.drawable.course3,
    body = "Description\n" +
            "You’ve just stumbled upon the most complete, in-depth Java programming course online.\n" +
            "\n" +
            "Whether you want to:\n" +
            "\n" +
            "- build the skills you need to get your first Java programming job\n" +
            "\n" +
            "- succeed in your university courses related to java and coding\n" +
            "\n" +
            "- move to a more senior software developer position\n" +
            "\n" +
            "- pass the oracle java certification exam\n" +
            "\n" +
            "- or just learn java to be able to create your own java apps quickly.\n" +
            "\n" +
            "...this complete Java developer course is the course you need to do all of this, and more.",
)




// ►► "COURSE 4"  ◄◄
val course4 = Courses(
    rating = 4.5f,
    title = "Mastering Design Patterns - Become a Professional Developer",
    R.drawable.course4,
    body = "Description\n" +
            "? Are you excited to learn design patterns, but they look complex and obscure.\n" +
            "\n" +
            "? Do you need real examples and step by step code implementation for these design patterns?\n" +
            "\n" +
            "? Are you looking to master the coding interview questions, excel in university exams , or even become  a professional Developer ???\n" +
            "\n" +
            "\n" +
            "\n" +
            "??? You came to the right place!  ???",
)



// ►► "COURSE 5"  ◄◄
val course5 = Courses(
    rating = 4.5f,
    title = "The Complete Data Structures & Algorithms Course in C & Java",
    R.drawable.course5,
    body = "Description\n" +
            "Want to land a job at a great tech company like Google, Microsoft, Facebook, Netflix, Amazon, or other companies but you are intimidated by the interview process and the coding questions? Do you find yourself feeling like you get \"stuck\" every time you get asked a coding question? This course is your answer. Using the strategies, lessons, and exercises in this course, you will learn how to land offers from all sorts of companies.\n" +
            "\n" +
            "Many developers who are \"self taught\", feel that one of the main disadvantages they face compared to college educated graduates in computer science is the fact that they don't have knowledge about algorithms, data structures and the notorious Big-O Notation. Get on the same level as someone with computer science degree by learning the fundamental building blocks of computer science which will give you a big boost during interviews. You will also get access to our private online chat community with thousands of developers online to help you get through the course.",
)



// ►► "COURSE 6"  ◄◄
val course6 = Courses(
    rating = 4.5f,
    title = "The Complete Android JetPack Course - Mastering Jetpack",
    R.drawable.course6,
    body = "Description\n" +
            "Do you want to level up your Android programming skills and call yourself a Senior Android Developer? Then my You came to the right place!\n" +
            "\n" +
            "In this course, you are going to learn how to use the Android Jetpack suite. This will allow you not only to learn new features of Android but also make sure that your code is up to date, clean, uses best practices, and is easily maintainable. A must for any developer who wants to call himself a professional developer.\n" +
            "\n",
)



// ►► "COURSE 7"  ◄◄
val course7 = Courses(
    rating = 4.5f,
    title = "The Complete Kotlin Course - Mastering Kotlin from Zero",
    R.drawable.course7,
    body = "Description\n" +
            "Are you confused from where you need to start learning coding?\n" +
            "\n" +
            "Are you a Java developer wondering if you need to learn Kotlin?\n" +
            "\n" +
            "Maybe you are an experienced Java developer who wants to learn Kotlin quickly, to be prepared for future project work.\n" +
            "\n" +
            "Perhaps instead, you're an Android app developer who knows Java well, but you want to be able to move forward with Kotlin for new Android development work.\n" +
            "\n" +
            "Because Kotlin works anywhere Java works, and can even be called from Java code (and vice-versa), this brings with it a massive opportunity for Java developers. Being able to work with both Java and Kotlin is going to give you a massive advantage over other programmers.\n" +
            "\n" +
            "In addition, the Kotlin syntax is explored in detail. Over Twelve hours of videos are include",
)



// ►► "COURSE 8"  ◄◄
val course8 = Courses(
    rating = 4.5f,
    title = "The Complete Firebase & Android Course - Mastering Firebase",
    R.drawable.course8,
    body = "Description\n" +
            "So you're looking for a back-end cloud for your Apps?  Looking to Advance your Coding Skills?\n" +
            "\n" +
            "You like to stay home & learn from your own computer?\n" +
            "\n" +
            "You heard about Back-end and Server-side jobs and you didn't start yet?\n" +
            "\n" +
            "You don't like to attend class?\n" +
            "\n" +
            "You need to learn about latest technology & app development?\n" +
            "\n" +
            "You have brilliant ideas & you need to develop them by creating your own apps by your hand?\n" +
            "\n" +
            "My name’s Abbass Masri, creator of the world’s best-selling Android Teaching app called: \"Master Android App\" … and the best-seller course on Udemy: \"The Complete Android 12",
)



// ►► "COURSE 9"  ◄◄
val course9 = Courses(
    rating = 4.5f,
    title = "Mastering Jetpack Compose: Building Dynamic User Interfaces",
    R.drawable.course9,
    body = "Description\n" +
            "Jetpack Compose is a modern and powerful UI toolkit for building Android applications. In this comprehensive course, you will learn how to leverage Jetpack Compose to create dynamic and visually stunning user interfaces (UI) for your Android apps.\n" +
            "\n" +
            "Whether you're a beginner or an experienced Android developer, this course will equip you with the skills and knowledge needed to master Jetpack Compose and take your UI development to the next level.",
)




// ♦ The "List" of "All Courses":
val allCourses = listOf(
    course1,
    course2,
    course3,
    course4,
    course5,
    course6,
    course7,
    course8,
    course9,
)
