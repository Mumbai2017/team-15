<?php;
	$cust_id=$_POST("");
	$address=$_POST("");
	$billamount=$_POST("");
	$preference=1;
	$created_at=mktime();
	$conn = mysqli_connect($servername, $username, $password, $dbname);
	if(!$conn) {
		die("Connection failed" . mysqli_error());
	}
 	else {
 		//echo "Connected successfully";
 	}
 	
 	$q="insert into orders values(null,'".$cust_id."','".$address."',".$billamount.",".$preference.",'".$created_at."')";
 	$conn->$query($q);
 	$sql = "select order_id from orders order by desc";
 	$order_id = $conn->$query($sql);

 	$quantity  = $__POST();
	$quantity = trim($quantity);
	if(strpos($quantity,' ') >= 0)
	{

	$pieces = explode(" ", $quantity);
	$i=0;
	for($i=0;$i<;$i++) {
		if($quantity[i] > 0)
		{
			$t = "insert into orders_quantity values('".$order_id.",".($i+1).",".quantity[i].")";
		}	
	}
	



?