<?php 

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "sanisa";

$conn = mysqli_connect($servername, $username, $password, $dbname);

if(!$conn) {
	die("connection failed" . mysqli_error());
}

$order_id = $_POST["user_id"];

$select_query = "select * from orders where user_id = " . $order_id . ";";
$result = mysqli_query($conn, $select_query);

$result = mysqli_fetch_assoc($result);

echo $result["order_id"];
echo $result["bill_amount"];
echo $result["created_at"];

?>