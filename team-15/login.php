<?php

$servername = "localhost";
$username = "root";
$password = "pratik12";
$dbname = "sanisa";

$conn = mysqli_connect($servername, $username, $password, $dbname);

if(!$conn) {
	die("Connection failed" . mysqli_error());
}
// else {
// 	echo "Connected successfully";
// }

$email = $_POST["email"];
$pwd = $_POST["pwd"];

$get_password_query = "select password from trial where email = \"" . $email . "\"";

$get_password = mysqli_query($conn, $get_password_query);
if (mysqli_num_rows($get_password) > 0) {
	$row = mysqli_fetch_assoc($get_password);
	if($row["password"] == $pwd)
	{
		$get_id_query = "select user_id from user where email_id = \"" . $email . "\";";
	// echo $get_id_query;
	$result_new = mysqli_query($conn, $get_id_query);
	$result_new = mysqli_fetch_assoc($result_new);
	echo $result_new["user_id"];
	}
	else {
	echo "-1";

}

}
?>