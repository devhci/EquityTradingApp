function validatePrice() {
		
		var limitPrice=document.getElementById("limitPrice").value;
	
		var stopPrice=document.getElementById("stopPrice").value;
		var limitPrice1=Math.abs(limitPrice);
		 var stopPrice1=Math.abs(stopPrice);
		if(limitPrice1<0 || isNaN(limitPrice1))
			{
			alert("Please enter a Non-Negative Number");
			document.getElementById("limitPrice").value=document.getElementById("ltPrice").value;
			return false;
			}
		if(stopPrice1<0 ||isNaN(stopPrice1))
			{
			alert("Please enter a Non-Negative Number");
			document.getElementById("stopPrice").value=document.getElementById("stPrice").value;
			return false;
			}
		else
			return true;
	
	}
	
	function validateEdit(){
		
		var side=document.getElementById("side").value;
		var limitPrice=document.getElementById("limitPrice").value;		
		var stopPrice=document.getElementById("stopPrice").value;
		
		
		var limitPrice1=Math.abs(limitPrice);
	 var stopPrice1=Math.abs(stopPrice);
		
		if(side==("SELL")||side==("sell")){
			if(stopPrice1>limitPrice1){
				alert("Stop Price Cannot be greater than limit Price for Sell Block Order");
			document.getElementById("limitPrice").value=document.getElementById("ltPrice").value;
			document.getElementById("stopPrice").value=document.getElementById("stPrice").value;
			return false;
			}
			else 
				return true;
		}
		else if(side==("BUY")||side==("buy")){
			if(stopPrice1<limitPrice1){
				alert("Stop Price Cannot be less than limit Price for Buy Block Order");
			document.getElementById("limitPrice").value=document.getElementById("ltPrice").value;
			document.getElementById("stopPrice").value=document.getElementById("stPrice").value;
			return false;
			}
			else 
				return true;
		}
		else 
			return true;
		
	}
	
	function validateExecution() {
		count = 0;
		str = '';
		for ( var x = 0; x < document.form1.elements["executionAllocateList"].length; x++) {
			if (document.form1.elements["executionAllocateList"][x].checked == true) {
				str += document.form1.elements["executionAllocateList"][x].value
						+ ',';
				count++;
			}
		}
		if (count == 0) {
			alert("You must choose at least 1 order to allocate");
			return false;
		} else {
			var r = confirm("Do you want to allocate the selected executions?");
			return r;
		}
	}
	
	function validateApprove() {
		var r = confirm("Do you want to approve selected allocations?");
		return r;
	}
	
	function validateRemove()
	{
		return confirm("Remove order?");
			}
	function execute(){
		
		return confirm("Do you really want to send the Block Order for execution?");
	}
	
	 function check() {
	
		var count1 = 0;
		
		var len= document.getElementsByName("blockOrderIdList").length;
		
		for (var x = 0; x <len; x++) {
			
			if ((document.form1.elements["blockOrderIdList"][x].checked )== true) {
				
				count1++;
			}
		}
		if ((count1==0)) {
			alert("You must choose at least 1 order to edit");
			return false;
		} else if (count1 > 1) {
			alert("You cannot edit more than 1 order together");
			return false;
		} else {
			return true;
		}
	} 
	function checkCancel() {
		count = 0;
		str = '';
		var len= document.getElementsByName("blockOrderIdList").length;
		for (var x = 0; x < len; x++) {
			if ((document.form1.elements["blockOrderIdList"][x].checked)== true) {
				str += document.form1.elements["blockOrderIdList"][x].value + ',';
				count++;
			}
		}
		if (count == 0) {
			alert("You must choose at least 1 order to remove");
			return false;
		}  else {
			return true;
		
	}
	}