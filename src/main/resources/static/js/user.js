let index = {
	init: function () {
		$("#btn-save").on("click", () => {
			this.save();
		});	
		$("#btn-update").on("click", () => {
			this.update();
		});
	},
	
	save: function () {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
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
	},
	
	update: function () {
			let data = {
				user_id: $("#id").val(),
				username: $("#username").val(),
				password: $("#password").val(),
				email: $("#email").val()
			};
			
			$.ajax({
				type: "PATCH",
				url: "/user/update",
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