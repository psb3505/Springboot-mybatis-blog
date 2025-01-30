let index = {
	init: function () {
		$("#btn-save").on("click", () => {
			this.save();
		});	
	},
	
	save: function () {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		console.log("btn-save 클릭");
		
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
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