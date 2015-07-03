<!DOCTYPE HTML>
<html>
<head>
<title>Simple API</title>
  		<script type="text/javascript" src="/cmsbackend/javascripts/jquery-2.1.4.min.js"></script>
  		<script type="text/javascript" src="/cmsbackend/javascripts/simple.js"></script>
</head>
<body>
		<hr>
		<h1>Post Json</h1>
		Action:<select id="urlSelect" onchange="chooseJson()">
			<option value="/index" selected>select items</option>
			<option value="website/save">Create website</option>
			<option value="website/update">Update website</option>
			<option value="website/updateStatus">Update website Status</option>
			<option value="website/delete">Delete website</option>
			<option value="page/save">Create Page</option>
			<option value="page/update">Update Page</option>
			<option value="page/updateStatus">Update Page Status</option>
			<option value="page/delete">Delete Page</option>
			<option value="page/saveContent">Save content of One page</option>
			<option value="pagetemplate/save">Create Pagetemplate</option>
			<option value="pagetemplate/update">Update Pagetemplate</option>
			<option value="pagetemplate/delete">Delete Pagetemplate</option>
			<option value="element/save">Create Element</option>
			<option value="element/update">Update Element</option>
			<option value="element/saveb">Create Element Plan B</option>
			<option value="element/updateb">Update Element Plan B</option>
			<option value="element/delete">Delete Element</option>
		</select>
		<br><br>
		request url:<input id="urlLebel" style="width:500px" readonly></input>
		<br><br>
		Value:<textarea cols="100" rows="20" id="postValue"></textarea>
		<br><br>
		<button onclick="postJson()">Test</button>
		
		<hr>
		<h1>Get Json</h1>
		Action:<select id="urlSelect1" onchange="chooseJson1()">
			<option value="/index" selected>select items</option>
			<option value="website/">Get All websites</option>
			<option value="website/single">Get one website by id</option>
			<option value="page/">Get All Pages By websiteId</option>
			<option value="page/single">Get one Page by id</option>
			<option value="page/parsePage">Format one Page and get The content</option>
			<option value="page/getContent">Get content of One page</option>
			<option value="pagetemplate/">Get All Pagetemplates By websiteId</option>
			<option value="pagetemplate/single">Get one Pagetemplate by id</option>
			<option value="element/">Get All Elements By websiteId</option>
			<option value="element/single">Get one Element by id</option>
		</select>
		<br><br>
		request url:<input id="urlLebel1" style="width:500px" readonly></input>
		<br><br>
		Param:<input id="param" type="text"></input><br><br>
		Result:<textarea cols="100" rows="20" id="result"></textarea>
		<br><br>
		<button onclick="getJson()">Test</button>
	</body>
</html>