package club.codehero.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 加密
 *
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/20 15:06
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123";
        System.out.println(encodePassword(password));
        //$2a$10$2LEsxCuc.f0Dub5k6xDod.7OSMdcl3.eYzxRmr1X78.qXrG4uBWdq
        //$2a$10$QXSLV5FesAT3txhUGQUjkeDl8HSjUMCOJQCHgWhBe78jf4isuV30m
    }
}
