<?php

$servername = "localhost";
$username = "root";
$password = "pratik12";
$dbname = "demo";

$conn = mysqli_connect($servername, $username, $password, $dbname);

if(!$conn) {
	die("Connection failed" . mysqli_error());
}
// else {
// 	echo "Connected successfully";
// }
;
$email = $_POST["email"];
$pwd = $_POST["pwd"];

$get_password_query = "select password from trial where email = \"" . $email . "\"";

$get_password = mysqli_query($conn, $get_password_query);
if (mysqli_num_rows($get_password) > 0) {
	$row = mysqli_fetch_assoc($get_password);
	if($row["password"] == $pwd)
	{
		echo "authorised";
	}
	else {
	echo "unauthorized";

}

}
mysqli_close($conn);
?>