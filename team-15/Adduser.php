 <?php
	$conn=mysqli_connect("localhost","root","","users");
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	
	} 
	//$que="insert into user values('vinay','passweb')";
	$que="insert into user values('".$_POST['email']."','".$_POST['name']."','".$_POST['pass']."')";
	if(mysqli_query($conn,$que)){
		echo "success";
	}
	else{
		echo "failed ".$que;
	}
 ?>