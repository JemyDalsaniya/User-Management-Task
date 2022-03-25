<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User Data</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link
	href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="custom/css/style.css" rel="stylesheet">


</head>
<body class="all_page_background">
	<jsp:include page="header.jsp" />
	<div class="container">
		<table id="example" class="table table-striped table-bordered table_css"
			>
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Contact</th>
					<th>Gender</th>
					<th>Hobby</th>
					<th>Profile</th>
					<th>Edit/Delete</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Tiger Nixon</td>
					<td>System Architect</td>
					<td>Edinburgh</td>
					<td>61</td>
					<td>2011/04/25</td>
					<td>$320,800</td>
					<td>hello</td>
					<td><a href="#"><i class="fa fa-pencil-square-o fa-lg "
							aria-hidden="true"></i></a> &nbsp;&nbsp;<a href="#"><i
							class="fa fa-trash fa-lg " aria-hidden="true"></i></a></td>
				</tr>
			</tbody>

		</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
	<jsp:include page="footer.jsp" />
</body>
</html>