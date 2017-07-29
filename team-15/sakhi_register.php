<?php

$servername = "localhost";
$username = "root";
$password = "pratik12";
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
$pick_start = $_POST["pick_up_time_start"];
$pick_close = $_POST["pick_up_time_close"];

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