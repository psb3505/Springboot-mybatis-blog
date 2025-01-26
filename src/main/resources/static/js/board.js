let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		})
	},
	
	save: function() {
		let data = {
			boardTitle: $("#boardTitle").val(),
			boardWriter: $("#boardWriter").val(),
			boardPass: $("#boardPass").val(),
			boardContents: $("#boardContents").val(),
		};
		
		console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/save",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8", 
			dataType: "json",
		})
		.done(function (resp) {
			alert("글쓰기가 완료되었습니다.");
			location.href = "/";
		})
		.fail(function(error) {
			alert(JSON.stringify(error));
		})
		
	}
	
};

index.init();