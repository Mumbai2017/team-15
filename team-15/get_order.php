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
if ($result->num_rows > 0) {
	while($row = $result->fetch_assoc()) {
		echo $row["order_id"]."=".$row["bill_amount"]."=".$row["created_at"];
	}
}

?>