package com.github.suusan2go.kotlinfillclass.quickfix

import com.intellij.codeInsight.intention.IntentionAction
import com.github.suusan2go.kotlinfillclass.intentions.FillClassIntention
import org.jetbrains.kotlin.diagnostics.Diagnostic
import org.jetbrains.kotlin.idea.quickfix.KotlinIntentionActionsFactory
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtConstructorCalleeExpression
import org.jetbrains.kotlin.psi.psiUtil.getNonStrictParentOfType
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType

object QuickFixFactory: KotlinIntentionActionsFactory() {
    override fun doCreateActions(diagnostic: Diagnostic): List<IntentionAction> {
        val element = diagnostic.psiElement.getNonStrictParentOfType<KtCallExpression>() ?: return emptyList()
        val fixes = ArrayList<IntentionAction>()
        fixes.add(
                FillClassIntention(element)
        )
        return fixes
    }
}

