<?php

$servername = "localhost";
$username = "root";
$password = "pratik12";

$conn = mysqli_connect($servername, $username, $password);

$trial = file_get_contents("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyBCyvmvjHJMyzuZf9oMLNrrQwnrqNgguKE");

echo $trial;

if(!$conn) {
	die("Connection failed" . mysqli_error());
}
else {
	echo "Connected successfully";
}
?>