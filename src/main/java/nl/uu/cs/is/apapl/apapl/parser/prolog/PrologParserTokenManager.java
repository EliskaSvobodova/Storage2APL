/* Generated By:JavaCC: Do not edit this line. PrologParserTokenManager.java */
package nl.uu.cs.is.apapl.apapl.parser.prolog;

/** Token Manager. */
public class PrologParserTokenManager implements PrologParserConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x6000000240L) != 0L)
            return 2;
         if ((active0 & 0xfc000080000000L) != 0L || (active1 & 0x40L) != 0L)
         {
            jjmatchedKind = 19;
            return 28;
         }
         return -1;
      case 1:
         if ((active0 & 0x200L) != 0L)
            return 0;
         if ((active0 & 0x80000000L) != 0L || (active1 & 0x40L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 19;
               jjmatchedPos = 1;
            }
            return 28;
         }
         if ((active0 & 0xc8000000000000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 19;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 2:
         if ((active0 & 0x80000000L) != 0L || (active1 & 0x40L) != 0L)
         {
            jjmatchedKind = 19;
            jjmatchedPos = 2;
            return 28;
         }
         if ((active0 & 0xc8000000000000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 19;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 32:
         jjmatchedKind = 1;
         return jjMoveStringLiteralDfa1_0(0xa000000000000000L, 0x7L);
      case 33:
         return jjStopAtPos(0, 30);
      case 36:
         return jjStopAtPos(0, 71);
      case 37:
         return jjStopAtPos(0, 7);
      case 40:
         return jjStopAtPos(0, 21);
      case 41:
         return jjStopAtPos(0, 22);
      case 42:
         jjmatchedKind = 35;
         return jjMoveStringLiteralDfa1_0(0x1000000000L, 0x0L);
      case 43:
         return jjStopAtPos(0, 32);
      case 44:
         return jjStopAtPos(0, 28);
      case 45:
         jjmatchedKind = 33;
         return jjMoveStringLiteralDfa1_0(0x400000000L, 0x0L);
      case 46:
         return jjStopAtPos(0, 29);
      case 47:
         jjmatchedKind = 37;
         return jjMoveStringLiteralDfa1_0(0x4000000240L, 0x0L);
      case 58:
         return jjStopAtPos(0, 67);
      case 59:
         return jjStopAtPos(0, 27);
      case 60:
         jjmatchedKind = 56;
         return jjMoveStringLiteralDfa1_0(0x200000000000000L, 0x0L);
      case 61:
         jjmatchedKind = 39;
         return jjMoveStringLiteralDfa1_0(0x1f0000000000L, 0x20L);
      case 62:
         jjmatchedKind = 58;
         return jjMoveStringLiteralDfa1_0(0x1800000000000000L, 0x0L);
      case 63:
         return jjStopAtPos(0, 72);
      case 64:
         return jjMoveStringLiteralDfa1_0(0xfc000000000000L, 0x0L);
      case 91:
         return jjStopAtPos(0, 25);
      case 92:
         jjmatchedKind = 45;
         return jjMoveStringLiteralDfa1_0(0x3c00000000000L, 0x0L);
      case 93:
         return jjStopAtPos(0, 26);
      case 94:
         return jjStopAtPos(0, 62);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x40L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x80000000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 23);
      case 124:
         return jjStopAtPos(0, 68);
      case 125:
         return jjStopAtPos(0, 24);
      default :
         return jjMoveNfa_0(3, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0, long active1)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1);
      return 1;
   }
   switch(curChar)
   {
      case 42:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(1, 9, 0);
         else if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(1, 36);
         break;
      case 43:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 46);
         break;
      case 46:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000000L, active1, 0L);
      case 47:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         else if ((active0 & 0x800000000000L) != 0L)
            return jjStopAtPos(1, 47);
         break;
      case 58:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000000000L, active1, 0L);
      case 60:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 42);
         else if ((active0 & 0x10000000000000L) != 0L)
            return jjStopAtPos(1, 52);
         else if ((active0 & 0x200000000000000L) != 0L)
            return jjStopAtPos(1, 57);
         break;
      case 61:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStopAtPos(1, 44);
         else if ((active0 & 0x1000000000000L) != 0L)
         {
            jjmatchedKind = 48;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x1000000000000000L) != 0L)
            return jjStopAtPos(1, 60);
         return jjMoveStringLiteralDfa2_0(active0, 0x4a000000000000L, active1, 0L);
      case 62:
         if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(1, 34);
         else if ((active0 & 0x20000000000000L) != 0L)
         {
            jjmatchedKind = 53;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x800000000000000L) != 0L)
            return jjStopAtPos(1, 59);
         else if ((active1 & 0x20L) != 0L)
            return jjStopAtPos(1, 69);
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000000000L, active1, 0L);
      case 92:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStopAtPos(1, 38);
         return jjMoveStringLiteralDfa2_0(active0, 0x80020000000000L, active1, 0L);
      case 100:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x2L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000000000000L, active1, 0L);
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x4L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x40L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000L, active1, 0L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x1L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000000000000L, active1, 0L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(0, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, active1);
      return 2;
   }
   switch(curChar)
   {
      case 46:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStopAtPos(2, 43);
         break;
      case 60:
         if ((active0 & 0x8000000000000L) != 0L)
            return jjStopAtPos(2, 51);
         break;
      case 61:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStopAtPos(2, 40);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStopAtPos(2, 41);
         else if ((active0 & 0x2000000000000L) != 0L)
            return jjStopAtPos(2, 49);
         else if ((active0 & 0x4000000000000L) != 0L)
            return jjStopAtPos(2, 50);
         else if ((active0 & 0x40000000000000L) != 0L)
            return jjStopAtPos(2, 54);
         else if ((active0 & 0x80000000000000L) != 0L)
            return jjStopAtPos(2, 55);
         break;
      case 100:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x40L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x1L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x2L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000000000000L, active1, 0x4L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000000000000L, active1, 0L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000L, active1, 0L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0, active1);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(1, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, active1);
      return 3;
   }
   switch(curChar)
   {
      case 32:
         if ((active0 & 0x80000000L) != 0L)
            return jjStopAtPos(3, 31);
         else if ((active0 & 0x2000000000000000L) != 0L)
            return jjStopAtPos(3, 61);
         else if ((active1 & 0x40L) != 0L)
            return jjStopAtPos(3, 70);
         break;
      case 100:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x4L);
      case 109:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x1L);
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000000000000L, active1, 0L);
      case 118:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x2L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, active1);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(2, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, active1);
      return 4;
   }
   switch(curChar)
   {
      case 32:
         if ((active0 & 0x8000000000000000L) != 0L)
            return jjStopAtPos(4, 63);
         else if ((active1 & 0x1L) != 0L)
            return jjStopAtPos(4, 64);
         else if ((active1 & 0x2L) != 0L)
            return jjStopAtPos(4, 65);
         else if ((active1 & 0x4L) != 0L)
            return jjStopAtPos(4, 66);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0, active1);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 31;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                     jjCheckNAddTwoStates(6, 7);
                  }
                  else if (curChar == 34)
                     jjCheckNAddStates(0, 2);
                  else if (curChar == 39)
                     jjCheckNAddTwoStates(10, 11);
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 2;
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 15)
                        kind = 15;
                     jjCheckNAdd(5);
                  }
                  break;
               case 0:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if ((0xffff7fffffffffffL & l) != 0L && kind > 8)
                     kind = 8;
                  break;
               case 2:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 4:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAdd(5);
                  break;
               case 5:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAdd(5);
                  break;
               case 6:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAddTwoStates(6, 7);
                  break;
               case 7:
                  if (curChar == 46)
                     jjCheckNAdd(8);
                  break;
               case 8:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAdd(8);
                  break;
               case 9:
                  if (curChar == 39)
                     jjCheckNAddTwoStates(10, 11);
                  break;
               case 10:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 12:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 13:
                  if (curChar == 39 && kind > 17)
                     kind = 17;
                  break;
               case 14:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(6, 9);
                  break;
               case 15:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 16:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 17:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(15);
                  break;
               case 18:
                  if (curChar == 34)
                     jjCheckNAddStates(0, 2);
                  break;
               case 19:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 21:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 22:
                  if (curChar == 34 && kind > 18)
                     kind = 18;
                  break;
               case 23:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(10, 13);
                  break;
               case 24:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 25:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 26:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(24);
                  break;
               case 28:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 30:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjstateSet[jjnewStateCnt++] = 30;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
                  if ((0x87fffffeL & l) != 0L)
                  {
                     if (kind > 20)
                        kind = 20;
                     jjCheckNAdd(30);
                  }
                  else if ((0x7fffffe00000001L & l) != 0L)
                  {
                     if (kind > 19)
                        kind = 19;
                     jjCheckNAdd(28);
                  }
                  break;
               case 1:
                  if (kind > 8)
                     kind = 8;
                  break;
               case 10:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 11:
                  if (curChar == 92)
                     jjAddStates(14, 16);
                  break;
               case 12:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 19:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 20:
                  if (curChar == 92)
                     jjAddStates(17, 19);
                  break;
               case 21:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 27:
                  if ((0x7fffffe00000001L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(28);
                  break;
               case 28:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(28);
                  break;
               case 29:
                  if ((0x87fffffeL & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(30);
                  break;
               case 30:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(30);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L && kind > 8)
                     kind = 8;
                  break;
               case 10:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(3, 5);
                  break;
               case 19:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(0, 2);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 31 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_4()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_4(0x2000L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_4(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(1, 13);
         break;
      default :
         return 2;
   }
   return 2;
}
private int jjMoveStringLiteralDfa0_1()
{
   return jjMoveNfa_1(0, 0);
}
private int jjMoveNfa_1(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x2400L & l) != 0L)
                  {
                     if (kind > 10)
                        kind = 10;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if (curChar == 10 && kind > 10)
                     kind = 10;
                  break;
               case 2:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_3()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_3(0x1000L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_3(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x1000L) != 0L)
            return jjStopAtPos(1, 12);
         break;
      default :
         return 2;
   }
   return 2;
}
private int jjMoveStringLiteralDfa0_2()
{
   return jjMoveNfa_2(0, 0);
}
private int jjMoveNfa_2(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x2400L & l) != 0L)
                  {
                     if (kind > 11)
                        kind = 11;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if (curChar == 10 && kind > 11)
                     kind = 11;
                  break;
               case 2:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   19, 20, 22, 10, 11, 13, 10, 11, 15, 13, 19, 20, 24, 22, 12, 14, 
   16, 21, 23, 25, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, "\50", "\51", "\173", "\175", 
"\133", "\135", "\73", "\54", "\56", "\41", "\156\157\164\40", "\53", "\55", "\55\76", 
"\52", "\52\52", "\57", "\57\134", "\75", "\75\72\75", "\75\134\75", "\75\74", 
"\75\56\56", "\75\75", "\134", "\134\53", "\134\57", "\134\75", "\134\75\75", "\100\76\75", 
"\100\75\74", "\100\74", "\100\76", "\100\75\75", "\100\134\75", "\74", "\74\74", "\76", 
"\76\76", "\76\75", "\40\151\163\40", "\136", "\40\170\157\162\40", 
"\40\162\145\155\40", "\40\144\151\166\40", "\40\155\157\144\40", "\72", "\174", "\75\76", 
"\141\156\144\40", "\44", "\77", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "IN_SINGLE_LINE_COMMENT",
   "IN_SINGLE_LINE_COMMENT_STD_PROLOG",
   "IN_FORMAL_COMMENT",
   "IN_MULTI_LINE_COMMENT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, 1, 2, 3, 4, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xffffffffffff8001L, 0x1ffL, 
};
static final long[] jjtoSkip = {
   0x3c3eL, 0x0L, 
};
static final long[] jjtoSpecial = {
   0x3c00L, 0x0L, 
};
static final long[] jjtoMore = {
   0x43c0L, 0x0L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[31];
private final int[] jjstateSet = new int[62];
private final StringBuilder jjimage = new StringBuilder();
private StringBuilder image = jjimage;
private int jjimageLen;
private int lengthOfMatch;
protected char curChar;
/** Constructor. */
public PrologParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public PrologParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 31; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 5 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 13 && (0x3600L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         if (jjmatchedPos == 0 && jjmatchedKind > 14)
         {
            jjmatchedKind = 14;
         }
         break;
       case 2:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_2();
         if (jjmatchedPos == 0 && jjmatchedKind > 14)
         {
            jjmatchedKind = 14;
         }
         break;
       case 3:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_3();
         if (jjmatchedPos == 0 && jjmatchedKind > 14)
         {
            jjmatchedKind = 14;
         }
         break;
       case 4:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_4();
         if (jjmatchedPos == 0 && jjmatchedKind > 14)
         {
            jjmatchedKind = 14;
         }
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           matchedToken.specialToken = specialToken;
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
           {
              matchedToken = jjFillToken();
              if (specialToken == null)
                 specialToken = matchedToken;
              else
              {
                 matchedToken.specialToken = specialToken;
                 specialToken = (specialToken.next = matchedToken);
              }
              SkipLexicalActions(matchedToken);
           }
           else
              SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
        jjimageLen += jjmatchedPos + 1;
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
