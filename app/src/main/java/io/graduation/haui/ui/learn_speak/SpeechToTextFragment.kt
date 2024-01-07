package io.graduation.haui.ui.learn_speak

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import io.graduation.haui.bases.BaseFragment
import io.graduation.haui.databinding.FragmentSpeechToTextBinding

class SpeechToTextFragment : BaseFragment<FragmentSpeechToTextBinding>(
    FragmentSpeechToTextBinding::inflate
), RecognitionListener {

    companion object {
        const val REQUEST_CODE_PERMISSION = 1
    }

    private lateinit var speechRecognizer: SpeechRecognizer

    override fun initData() {
        super.initData()
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireContext())
        speechRecognizer.setRecognitionListener(this)
    }

    override fun handleEvent() {
        super.handleEvent()
        binding.st.setOnClickListener {
            val permission = Manifest.permission.RECORD_AUDIO
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(permission),
                    REQUEST_CODE_PERMISSION
                )
            } else {
                startRecording()
            }
        }

        binding.ed.setOnClickListener {
            stopRecording()
        }
    }

    private fun startRecording() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE,
            "en-US"
        )
        intent.putExtra(RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES, "en-US")
        speechRecognizer.startListening(intent)
    }

    private fun stopRecording() {
        speechRecognizer.stopListening()
    }

    override fun onReadyForSpeech(params: Bundle?) {

    }

    override fun onBeginningOfSpeech() {

    }

    override fun onRmsChanged(p0: Float) {

    }

    override fun onBufferReceived(p0: ByteArray?) {

    }

    override fun onEndOfSpeech() {

    }

    override fun onError(error: Int) {

    }

    override fun onResults(results: Bundle?) {
        val textResults = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        if (!textResults.isNullOrEmpty()) {
            val spokenText = textResults[0]
            Toast.makeText(requireContext(), spokenText, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPartialResults(p0: Bundle?) {

    }

    override fun onEvent(p0: Int, p1: Bundle?) {

    }
}