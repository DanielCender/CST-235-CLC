package services;

import javax.ejb.Local;
import javax.servlet.http.Cookie;

@Local
public interface CookieServiceInterface {
	public void setCookie(String name, String value, int expiry);
	public Cookie getCookie(String name);
}
