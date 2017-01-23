# Pustak
App to search books available(along with author names) by entering a keyword (uses Google Books API)

Pustak is a Hindi word which means Book. To search a book, enter the title of the book or any keyword. The app then sends the word whatever you have written in the search field to Google Books API and after receiving the JSON response, it will extract the necessary details from it and display them in a List manner.

The app uses AsyncTask to communicate as you can't do Network calls on Main thread. Although AsyncTask has some disadvantages but it is idle for short operations(few seconds). I have not used any networking library such as Retrofit or Volley(for implementation of Retrofit, see my InstaNyooz app https://github.com/deeps2/InstaNyooz). Inside Utils.java you can see methods for creating URL, making HTTP request, reading data from Input Stream and parsing JSON response to get the desired information. If the device is not connected to internet or no books were found matching to the keyword entererd then a corresponding message will be displayed.

Components Used
---------------
AsyncTask</br>
ListView</br>
Custom ArrayAdapter</br>
Google Books API

ScreenShots
------------
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/news1.jpg?alt=media&token=52e72d1f-e854-4b74-9f08-5d9dc01ebd3d" width=280/>&nbsp;&nbsp;
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/news2.jpg?alt=media&token=eed4e243-00a0-46fa-a83a-002163e48f33" width=280/>&nbsp;&nbsp;
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/news4.jpg?alt=media&token=3cc79c54-7fa6-402a-8e6d-64936e68b055" width=280/>

Video Demo
----------
https://www.youtube.com/watch?v=V1bDaFQhTMw

This app is a project work done by me under Udacity Android Basics Nanodegree. Thanks to course videos provided by Udacity.
