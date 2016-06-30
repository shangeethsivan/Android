
<?php
include('db_config.php');

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "select * from sample";
$res = mysqli_query($conn,$sql);

$result=array();
while($row = mysqli_fetch_array($res)){
    array_push($result,
    array('name'=>$row[0],
    'number'=>$row[1]));
}
echo json_encode(array("result"=>$result));

  mysqli_close($conn);

?>
