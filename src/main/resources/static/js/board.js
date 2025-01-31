let index = {
	init: function () {
		$("#btn-save").on("click", () => {
			this.save();
		});	
	},
	
	save: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8", 
	      	dataType: "json"
		})
		.done(function (resp) {
			alert(resp.message);
			location.href = "/";
		})
		.fail(function (error) {
			if(error.status === 400) {
				let errorMessage = error.responseJSON.map(err => err.defaultMessage).join("\n");
				alert(errorMessage);
			}
		});
	}
	
}

index.init();