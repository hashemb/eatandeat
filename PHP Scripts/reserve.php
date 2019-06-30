
<?php
	$id = $_GET['id'];
	$tid = $_GET["tid"];
	$date = $_GET["date"];
	$stime = $_GET["stime"];
	$etime = $_GET["etime"];
	$isVIP = $_GET["isVIP"];
	$Kids = $_GET["Kids"];
	$paymentM = $_GET["paymentM"];
	
	$reservable = true;
	$starttime;
	$endtime;
	
	include('Connection.php');
	
	$query = "SELECT * FROM `reserve` WHERE tid = '$tid' AND date='$date';";
	$result=mysqli_query($con, $query);
	$nbrows=mysqli_num_rows($result);
	if ($nbrows > 0){
		while($row = mysqli_fetch_array($result)){
			$starttime = strtotime($row['stime']);
			$endtime = strtotime($row['etime']);
			$s=strtotime($stime);
			$e=strtotime($etime);
			if((($e >= $starttime) && ($e <= $endtime))
			|| (($s >= $starttime) && ($s <= $endtime)))
			{
				echo "This table is reserved at this time";
				$reservable = false;
			}
		}
	
	}
	
	if($reservable){
		$query="INSERT INTO `reserve` VALUES (NULL, '$id', '$tid', '$date', '$stime', '$etime', '$isVIP', '$Kids', '$paymentM');";
		if(!$result=mysqli_query($con, $query)) echo mysqli_error($con);
		echo "Reserved Successfully";			
	}
	
?>


