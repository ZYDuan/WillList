/**
 * 
 */
package com.zyd.utils;

import java.sql.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

/**
 * @author zyd
 * @date 2017年12月14日 下午2:53:52
 * @ClassName: TokenUtil
 */
public class JWTUtil {

	// 获得key
	private static Key getKeyInstance() {
		// 根据HS256算法生成密匙
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("WillList");
		System.out.println(apiKeySecretBytes);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		return signingKey;
	}

	// 生成token
	public static String createJWT(String id, String subject, long ttlMillis) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		Key secretKey = getKeyInstance();

		// 根据信息生成token
		JwtBuilder builder = Jwts.builder().setId(id).setSubject(subject).setIssuedAt(now).signWith(signatureAlgorithm,
				secretKey);

		// 判断传入的时间参数是否正确并设置为token的有效时间
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date expDate = new Date(expMillis);
			builder.setExpiration(expDate);
		}

		return builder.compact();
	}

	// 验证token
	public static CheckResult verifyJWT(String jwt) {
		System.out.println(jwt);
		CheckResult checkResult = new CheckResult();
		// 通过验证token返回不同的结果
		try {
			checkResult.setChaims(parseJWT(jwt));
			checkResult.setCheckCode(CodeUtil.JWT_SUCCESS);
			return checkResult;
		} catch (ExpiredJwtException e) {
			checkResult.setCheckCode(CodeUtil.JWT_ERRCODE_EXPIRE);
			e.printStackTrace();
			return checkResult;
		} catch (SignatureException e) {
			checkResult.setCheckCode(CodeUtil.JWT_ERRCODE_FAIL);
			e.printStackTrace();
			return checkResult;
		} catch (Exception e) {
			checkResult.setCheckCode(CodeUtil.JWT_ERRCODE_FAIL);
			e.printStackTrace();
			return checkResult;
		}
	}

	// 解析jwt
	public static Claims parseJWT(String jwt) {
		// 获得密匙解析token
		Key secretKey = getKeyInstance();
		Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt);
		Claims claims = parseClaimsJws.getBody();
		return claims;
	}
}
