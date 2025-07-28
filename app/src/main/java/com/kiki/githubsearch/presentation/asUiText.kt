package com.kiki.githubsearch.presentation

import com.kiki.githubsearch.R
import com.kiki.githubsearch.domain.DataError
import com.kiki.githubsearch.domain.Result

fun DataError.asUiText(): UiText {
    return when (this) {
        DataError.Local.FILE_NOT_FOUND -> UiText.StringResource(R.string.file_not_found)

        DataError.Remote.REQUEST_TIMEOUT -> UiText.StringResource(R.string.request_time_out)

        DataError.Remote.NO_INTERNET -> UiText.StringResource(R.string.no_internet)

        DataError.Remote.UNABLE_TO_REACH_SERVER -> UiText.StringResource(R.string.unable_reach_server)

        DataError.Remote.SSL_ERROR -> UiText.StringResource(R.string.ssl_error)

        DataError.Remote.BAD_REQUEST -> UiText.StringResource(R.string.bad_request)

        DataError.Remote.UNAUTHORIZED -> UiText.StringResource(R.string.unauthorized)

        DataError.Remote.ACCESS_DENIED -> UiText.StringResource(R.string.access_denied)

        DataError.Remote.NOT_FOUND -> UiText.StringResource(R.string.not_found)

        DataError.Remote.SERVER_ERROR -> UiText.StringResource(R.string.server_error)

        DataError.Remote.UNKNOWN -> UiText.StringResource(R.string.uknown)

        DataError.Local.UNKNOWN -> UiText.StringResource(R.string.uknown)
    }
}

fun Result.Error<*, DataError>.asErrorUiText(): UiText {
    return error.asUiText()
}