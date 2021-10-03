$("#test").click(function(){
    $.ajax({
    type : 'GET',
    url : "rest/reader",
    success : function(obj, textStatus, jqXHR) {
		obj = JSON.parse(obj);
		console.log(obj);
        for (var i = 0; i < obj.length; i++) {
            var tr = "<tr>";
            var td0 = "<td>" + (i + 1) + "</td>";
            var td1 = "<td>" + obj[i].book_name + "</td>";
            var td2 = "<td>" + obj[i].author + "</td>";
            var td3 = "<td>" + obj[i].chapter + "</td>";
            var td4 = "<td>" + obj[i].content + "</td></tr>";
            $("#mytable1").append(tr + td0 + td1 + td2 + td3 + td4);
	        	}
	    	}
		}
	)
})