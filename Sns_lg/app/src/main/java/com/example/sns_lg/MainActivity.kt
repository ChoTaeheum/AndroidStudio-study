package com.example.sns_lg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause

import com.nhn.android.naverlogin.OAuthLogin
import com.nhn.android.naverlogin.OAuthLoginHandler
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton
import com.nhn.android.naverlogin.OAuthLogin.mOAuthLoginHandler

class MainActivity : AppCompatActivity() {

    lateinit var mOAuthLoginInstance: OAuthLogin
    lateinit var mContext: Context
    private lateinit var mOAuthLoginButton: OAuthLoginButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val naver_client_id = "6J4exfBfEYa04xycj9JO"
        val naver_client_secret = "4xMM1n_O3z"
        val naver_client_name = "Sns_lg"

        mContext = this
        val mOAuthLoginInstance = OAuthLogin.getInstance()
        mOAuthLoginInstance.init(mContext, naver_client_id, naver_client_secret, naver_client_name)

        mOAuthLoginButton = findViewById<View>(R.id.btn_naverlogin) as OAuthLoginButton
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler)

        val mOAuthLoginHandler: OAuthLoginHandler = object : OAuthLoginHandler() {
            override fun run(success: Boolean) {
                if (success) {
//                    val accessToken: String = mOAuthLoginInstance.getAccessToken(mContext)
//                    val refreshToken: String = mOAuthLoginInstance.getRefreshToken(mContext)
//                    val expireAt: Long = mOAuthLoginInstance.getExpiresAt(mContext)
//                    val tokenType: String = mOAuthLoginInstance.getTokenType(mContext)

                    Toast.makeText(mContext, "로그인 성공!!!", Toast.LENGTH_SHORT).show();
                    redirectSignupActivity()
                } else {
                    val errorCode: String =
                        mOAuthLoginInstance.getLastErrorCode(mContext)
                            .getCode()
                    val errorDesc: String =
                        mOAuthLoginInstance.getLastErrorDesc(mContext)
                    Toast.makeText(
                        mContext,
                        "errorCode: $errorCode, errorDesc :$errorDesc", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        mOAuthLoginButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                // 클릭이 되면 로그인 액티비티가 시작이 된다.
                mOAuthLoginInstance.startOauthLoginActivity(
                    mContext as MainActivity,
                    mOAuthLoginHandler
                )
            }
        })
    }



        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
            } else if (token != null) {
                Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                redirectSignupActivity()
            }
        }

        val kakao_login_button = findViewById<ImageButton>(R.id.kakao_login_button)


    protected fun redirectSignupActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finish()
    }
}