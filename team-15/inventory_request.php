<?php
<<<<<<< HEAD
	
=======

$servername = "localhost";
$username = "root";
$password = "pratik12";
$dbname = "sanisa";

	$user_id=$_POST["user_id"];//$_SESSION("user_id");
	$item_id=$_POST["item_id"];
	$quantity=$_POST["quantity"];
	$booked_date=mkdate();
	$status=$_POST["status"];
>>>>>>> 1891c7d7dbd9f18d3f33693b5514ed43c0e2bc05
	
	$connection=mysqli_connnect($servername, $username, $password, $dbname);
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
<<<<<<< HEAD
	}
	$select_db=mysqli_select_db('');
	if(!$select_db){
		die("Database connection failed".mysql_error($select_db));
	}
	
	for(i=0;i<9;i++)
	{
		
		$user_id=$_POST("");//$_SESSION("user_id");
		$item_id=$_POST("");
		$quantity=$_POST("");
		$booked_date=mkdate();
		$status=$_POST("");
		if($quantity!=0){
		$query="insert into inventory_request values(".$user_id",".$item_id.",".$quantity.",".$booked_date.","$status");"
		$query1="update inventory set values="" "
		}
	}
=======
	}	
	
	$query="insert into inventory_request values(".$user_id",".$item_id.",".$quantity.",".$booked_date.","$status");"

	$query_run = mysqli_query($connection, $query);
	
>>>>>>> 1891c7d7dbd9f18d3f33693b5514ed43c0e2bc05
?>