<?php

$servername = "localhost";
$username = "root";
$password = "pratik12";
$dbname = "sanisa";

$conn = mysqli_connect($servername, $username, $password, $dbname);

if(!$conn) {
	die("connection failed" . mysqli_error());
}

$name = $_POST["user"];
$email = $_POST["user"];
$pwd = $_POST["pass"];
$type = "1";
$address = $_POST["addr"];
$mobile_number = $_POST["phn"];
$online = "1";
$pick_start = $_POST["time"];
$pick_close = $_POST["time"];

// echo "hello";
$register_query = "insert into user values (null, \"" . $name . "\",\"" . $email . "\",\"" . $pwd . "\"," . $type . ",\"" . $address . "\"," . $mobile_number . "," . $online . ");";
// echo $register_query;
$result = mysqli_query($conn, $register_query);

$get_id_query = "select user_id from user where email_id = \"" . $email . "\";";
// echo $get_id_query;
$result_new = mysqli_query($conn, $get_id_query);
$result_new = mysqli_fetch_assoc($result_new);

$pickup_query = "insert into pickup values(" . $type . "," . $result_new["user-id"] . "," . $pick_start . "," . $pick_close . ");";
$result_pickup_query = mysqli_query($conn, $pickup_query);

$address_query = "insert into address values(" . $type . "," . $user_id . "," . $address . ",null,null);";
$result_address_query = mysqli_query($conn, $address_query);

echo $result_new["user_id"];
// echo "done";
?>