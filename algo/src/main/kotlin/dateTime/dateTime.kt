package dateTime

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.format
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.format.char

val currentDateTime = LocalDateTime(2024, 3, 1, 9, 15, 0, 0)
val currentDate = currentDateTime.date
val currentTime = currentDateTime.time

fun main(){
    currentDateTime.format(LocalDateTime.Format {
        // Use Unicode Pattern or Kotlin DSL
    })

    currentDate.format(LocalDate.Format {
        // Use Unicode Pattern or Kotlin DSL
    })

    currentTime.format(LocalTime.Format {
        // Use Unicode Pattern or Kotlin DSL
    })

    // 2024 03 01 - 09:15
    currentDateTime.format(LocalDateTime.Format { byUnicodePattern("yyyy MM dd - HH:mm") })

    // 2024/03/01
    currentDate.format(LocalDate.Format { byUnicodePattern("yyyy/MM/dd") })

    // 09:15
    currentTime.format(LocalTime.Format { byUnicodePattern("HH:mm") })


    // Mar 01 2024 - 09:15
    currentDateTime.format(
        LocalDateTime.Format {
            date(
                LocalDate.Format {
                    monthName(MonthNames.ENGLISH_ABBREVIATED)
                    char(' ')
                    dayOfMonth()
                    chars(" ")
                    year()
                }
            )
            chars(" - ")
            time(
                LocalTime.Format {
                    hour(); char(':'); minute()
                }
            )
        }
    )

    // Mar 01, 2024
    currentDate.format(LocalDate.Format {
        monthName(MonthNames.ENGLISH_ABBREVIATED)
        char(' ')
        dayOfMonth()
        chars(", ")
        year()
    })

    // 09:15
    currentTime.format(LocalTime.Format {
        hour()
        char(':')
        minute()
    })
}

