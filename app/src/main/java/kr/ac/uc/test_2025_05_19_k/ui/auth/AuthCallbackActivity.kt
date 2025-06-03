package kr.ac.uc.test_2025_05_19_k.ui.auth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kr.ac.uc.test_2025_05_19_k.MainActivity

class AuthCallbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val uri: Uri? = intent?.data
        if (uri != null && uri.toString().startsWith("com.mogacko://oauth2callback")) {
            val accessToken = uri.getQueryParameter("accessToken")
            val refreshToken = uri.getQueryParameter("refreshToken")
            val userId = uri.getQueryParameter("userId")

            if (!accessToken.isNullOrBlank() && !userId.isNullOrBlank()) {
                // 🔐 SharedPreferences에 토큰 저장
                getSharedPreferences("auth_prefs", MODE_PRIVATE).edit().apply {
                    putString("accessToken", accessToken)
                    putString("refreshToken", refreshToken)
                    putString("user_id", userId)
                    apply()
                }

                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

                // 🔥 로그 출력
                Log.d("AuthCallback", "accessToken: $accessToken")
                Log.d("AuthCallback", "refreshToken: $refreshToken")
                Log.d("AuthCallback", "userId: $userId")

            } else {
                Toast.makeText(this, "로그인 실패: 토큰 없음", Toast.LENGTH_SHORT).show()
            }
        }

        // 🔁 MainActivity로 돌아감
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        }

        startActivity(intent)
        finish()
    }
}
