$(document).ready(function() {
	$(".role_admin").on("change", function() {
		//var id = $(this).val();
		 var trid = $(this).closest('tr').attr('id'); // table row ID 
		console.log(trid);
		var is_checked = $(this).is(':checked');
		console.log(is_checked);
		  window.location.href = 'ChangeRole?userId='+trid;
	})
});