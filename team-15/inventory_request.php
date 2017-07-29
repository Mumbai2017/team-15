<?php
	
	
	$connection=mysqli_connnect("","","");
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
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
?>