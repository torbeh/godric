

import eu.godric.hoa.Member

class FacebookUser {

	long uid
  String accessToken
  Date accessTokenExpires

	static belongsTo = [user: Member]

	static constraints = {
		uid unique: true
	}
}
