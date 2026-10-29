import com.thoughtworks.gauge.Step
import com.thoughtworks.gauge.Table
import org.assertj.core.api.Assertions.assertThat

class StepImplementation {
    private var vowels: Set<Char> = emptySet()

    @Step("Vowels in English language are <vowelString>.")
    fun setLanguageVowels(vowelString: String) {
        vowels = vowelString.toSet()
    }

    @Step("The word <word> has <expectedCount> vowels.")
    fun verifyVowelsCountInWord(word: String, expectedCount: Int) {
        val actualCount = countVowels(word)
        assertThat(actualCount).isEqualTo(expectedCount)
    }

    @Step("Almost all words have vowels <wordsTable>")
    fun verifyVowelsCountInMultipleWords(wordsTable: Table) {
        for (row in wordsTable.tableRows) {
            val word = row.getCell("Word")
            val expectedCount = row.getCell("Vowel Count").toInt()
            val actualCount = countVowels(word)
            assertThat(actualCount).isEqualTo(expectedCount)
        }
    }

    private fun countVowels(word: String): Int {
        var count = 0
        for (ch in word.toCharArray()) {
            if (vowels.contains(ch)) {
                count++
            }
        }
        return count
    }
}
