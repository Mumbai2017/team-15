<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "sanisa";

$conn = mysqli_connect($servername, $username, $password, $dbname);

if(!$conn) {
	die("connection failed" . mysqli_error());
}

$name = $_POST["name"];
$email = $_POST["email"];
$pwd = $_POST["password"];
$type = $_POST["type"];
$address = $_POST["address"];
$mobile_number = $_POST["phone"];
$online = $_POST["online"];
// echo "hello";
$register_query = "insert into user values (null, \"" . $name . "\",\"" . $email . "\",\"" . $pwd . "\"," . $type . ",\"" . $address . "\"," . $mobile_number . "," . $online . ");";
//echo $register_query;
$result = mysqli_query($conn, $register_query);

$get_id = "select user_id from user where email_id = '".$email."'";
$result = mysqli_query($conn, $get_id);
if($result->num_rows > 0){
	$entry=mysqli_fetch_assoc($result);
	echo $entry['user_id'];
}else echo -1;
//echo $get_id;
// echo "done";
?>