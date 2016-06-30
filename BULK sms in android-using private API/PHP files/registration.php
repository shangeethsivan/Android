<?php
include('db_config.php');
$s_name=$_POST["username"];
$s_number=$_POST["password"];

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
//echo "Connected successfully";
//connection Success
if($s_name==''||$s_number=='')
{
	echo 'Please Fill The Fileds';
}
else {
	$sqltest = "SELECT * FROM sample WHERE name='$s_name'";
    $result = mysqli_query($conn,$sqltest);
    $check = mysqli_fetch_array($result);
	
 if(isset($check)){
 echo 'username already exist';
 } else
 {
   $sql = "INSERT INTO sample (name,number) VALUES ('$s_name', '$s_number')";
   $result = mysqli_query($conn,$sql);
   if ($result == TRUE)
	   {
		     echo "success";
       } 
else {
    echo "Error";
}
 }
 mysqli_close($conn);
}
?>
