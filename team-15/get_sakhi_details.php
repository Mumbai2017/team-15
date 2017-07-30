<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "sanisa";

$conn = mysqli_connect($servername, $username, $password, $dbname);

$get_details_query = "select * from user where user_id = 1;";

$run_query = mysqli_query($conn, $get_details_query);

if(mysqli_num_rows($run_query) > 0) {
	if ($result = mysqli_fetch_assoc($run_query) != null) {
		echo $result["user_id"];
		echo $result["name"];
		echo $result["email_id"];
		echo $result["password"];
		echo $result["type"];
		echo $result["res_address"];
		echo $result["mobile_number"];
		echo $result["online"];	
	}
}

?>