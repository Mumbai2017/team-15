<?php
	

	$nm



	$sakhi_id=select sakhi_id from  order_quantity, order_schedule where status="True" && order_quantity.order_id=order_schedule.order_id;
	$item=select item_id,quantity from order_quantity;
	//$invent=select * from inventory where user_id=$sakhi_id && item=$item[0];

	for($x=0;sizeof($x))
	{
		$query="update inventory set quantity=quantity-$item[1] where user_id=$sakhi_id && item=$item[0];"


	}

?>