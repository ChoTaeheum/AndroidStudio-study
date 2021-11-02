package com.example.sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast

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

        val naver_client_id = "QOOuuBIcN9nkbqoYVSh1"
        val naver_client_secret = "ntXeoqxKCO"
        val naver_client_name = "naver_login"


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

        mOAuthLoginButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                // 클릭이 되면 로그인 액티비티가 시작이 된다.
                mOAuthLoginInstance.startOauthLoginActivity(
                    mContext as MainActivity,
                    mOAuthLoginHandler
                )
            }
        } )
    }

    protected fun redirectSignupActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)




        finish()
    }
}
