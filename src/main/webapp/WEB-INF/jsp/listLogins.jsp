<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>

</head>

<head>
<meta charset="windows-1256">
<title>Logins</title>
</head>
<body>
	<div class="container">
		<div class="table">
			<div class="table-header">
				<div class="header__item">
					<a id="name" class="filter__link">Login</a>
				</div>
				<div class="header__item">
					<a id="wins" class="filter__link filter__link--number">Password</a>
				</div>
			</div>
			<div class="table-content">
				<c:forEach items="${list}" var="element">
					<div class="table-row">
						<div class="table-data">${element.login}</div>
						<div class="table-data">${element.pwd}</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	</div>
</body>
<style>
@import
	url('https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700');

*, *:before, *:after {
	box-sizing: border-box;
}

body {
	padding: 24px;
	font-family: 'Source Sans Pro', sans-serif;
	margin: 0;
}

h1, h2, h3, h4, h5, h6 {
	margin: 0;
}

.container {
	max-width: 1000px;
	margin-right: auto;
	margin-left: auto;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
}

.table {
	width: 100%;
	border: 1px solid #EEEEEE;
	margin-top: -30%;
}

.table-header {
	display: flex;
	width: 100%;
	background: #000;
	padding: 18px 0;
}

.table-row {
	display: flex;
	width: 100%;
	padding: 18px 0;
}

.table-row:nth-of-type(odd) {
	background: #EEEEEE;
}

.table-data, .header__item {
	flex: 1 1 20%;
	text-align: center;
}

.header__item {
	text-transform: uppercase;
}

.filter__link {
	color: white;
	text-decoration: none;
	position: relative;
	display: inline-block;
	padding-left: 24px;
	padding-right: 24px;
}

.filter__link::after {
	content: '';
	position: absolute;
	right: -18px;
	color: white;
	font-size: 12px;
	top: 50%;
	transform: translateY(-50%);
}

.filter__link.desc::after {
	content: '(desc)';
}

.filter__link.asc::after {
	content: '(asc)';
}
</style>
<script>
	var properties = [ 'name', 'wins', ];

	$.each(properties, function(i, val) {

		var orderClass = '';

		$("#" + val).click(
				function(e) {
					e.preventDefault();
					$('.filter__link.filter__link--active').not(this)
							.removeClass('filter__link--active');
					$(this).toggleClass('filter__link--active');
					$('.filter__link').removeClass('asc desc');

					if (orderClass == 'desc' || orderClass == '') {
						$(this).addClass('asc');
						orderClass = 'asc';
					} else {
						$(this).addClass('desc');
						orderClass = 'desc';
					}

					var parent = $(this).closest('.header__item');
					var index = $(".header__item").index(parent);
					var $table = $('.table-content');
					var rows = $table.find('.table-row').get();
					var isSelected = $(this).hasClass('filter__link--active');
					var isNumber = $(this).hasClass('filter__link--number');

					rows.sort(function(a, b) {

						var x = $(a).find('.table-data').eq(index).text();
						var y = $(b).find('.table-data').eq(index).text();

						if (isNumber == true) {

							if (isSelected) {
								return x - y;
							} else {
								return y - x;
							}

						} else {

							if (isSelected) {
								if (x < y)
									return -1;
								if (x > y)
									return 1;
								return 0;
							} else {
								if (x > y)
									return -1;
								if (x < y)
									return 1;
								return 0;
							}
						}
					});

					$.each(rows, function(index, row) {
						$table.append(row);
					});

					return false;
				});

	});
</script>

</html>