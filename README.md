# Pustak
App to search books available(along with author names) by entering a keyword (uses Google Books API)

Pustak is a Hindi word which means Book. To search a book, enter the title of the book or any keyword. The app then sends the word whatever you have written in the search field to Google Books API and after receiving the JSON response, it will extract the necessary details from it and display them in a List manner.

The app uses AsyncTask to communicate as you can't do Network calls on Main thread. Although AsyncTask has some disadvantages but it is idle for short operations(few seconds). I have not used any networking library such as Retrofit or Volley(for implementation of Retrofit, see my InstaNyooz app https://github.com/deeps2/InstaNyooz). Inside Utils.java you can see methods for creating URL, making HTTP request, reading data from Input Stream and parsing JSON response to get the desired information. If the device is not connected to internet or no books were found matching to the keyword entererd then a corresponding message will be displayed.

Components Used
---------------
AsyncTask</br>
ListView</br>
Custom ArrayAdapter</br>
Google Books API</br>
Methods for creating URL, making HTTP request and Parsing JSON response

ScreenShots
------------
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/book1.jpg?alt=media&token=bfeef0cb-f4fa-4918-9aa2-ebdfec70defa" width=280/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/book2.jpg?alt=media&token=4890e7cb-ed35-4306-802d-64db9630342e" width=280/></br></br>
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/book3.jpg?alt=media&token=ddd0e201-c901-4112-97e7-6c8e8c6d314d" width=280/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="https://firebasestorage.googleapis.com/v0/b/delhi06-31a81.appspot.com/o/book4.jpg?alt=media&token=8f623cb5-0f46-4b42-b6aa-3b5fcd93d694" width=280/>

Video Demo
----------
https://www.youtube.com/watch?v=V1bDaFQhTMw

This app is a project work done by me under Udacity Android Basics Nanodegree. Thanks to course videos provided by Udacity.
