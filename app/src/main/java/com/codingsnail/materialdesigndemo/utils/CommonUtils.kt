import android.text.TextUtils
import java.util.regex.Pattern

/**
 * Created by Snail on 3/1/2018 2:09 PM
 * Contact with slowsnail0223@gmail.com
 */

object CommonUtils {

    /**
     * 校验手机号码
     */
    fun verifyMobile(mobileNumber: String): Boolean {
        val regExp = "0?(13|15|17|18|14|19)[0-9]{9}$"
        val p = Pattern.compile(regExp)
        return if (!TextUtils.isEmpty(mobileNumber)) {
            val m = p.matcher(mobileNumber)
            m.find()
        } else {
            false
        }
    }

    /**
     * 验证登录密码
     */
    fun verifyLoginPwd(password: String): Boolean {
        return !TextUtils.isEmpty(password) && password.length >= 6 && password.length <= 16
    }
}