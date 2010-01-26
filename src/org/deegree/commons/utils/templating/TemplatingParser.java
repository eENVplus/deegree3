
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Tue Jan 26 11:01:38 CET 2010
//----------------------------------------------------

package org.deegree.commons.utils.templating;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java_cup.runtime.*;
import org.deegree.commons.utils.*;
import org.deegree.commons.utils.templating.lang.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Tue Jan 26 11:01:38 CET 2010
  */
public class TemplatingParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public TemplatingParser() {super();}

  /** Constructor which sets the default scanner. */
  public TemplatingParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public TemplatingParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\036\000\002\002\004\000\002\002\004\000\002\002" +
    "\005\000\002\002\004\000\002\002\005\000\002\003\004" +
    "\000\002\003\003\000\002\003\003\000\002\006\004\000" +
    "\002\006\003\000\002\007\004\000\002\007\004\000\002" +
    "\007\007\000\002\005\003\000\002\005\004\000\002\005" +
    "\004\000\002\005\003\000\002\005\003\000\002\005\003" +
    "\000\002\005\003\000\002\005\003\000\002\005\003\000" +
    "\002\005\005\000\002\005\004\000\002\005\004\000\002" +
    "\005\003\000\002\005\003\000\002\004\005\000\002\004" +
    "\004\000\002\004\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\053\000\006\005\006\006\005\001\002\000\004\002" +
    "\055\001\002\000\006\017\047\022\051\001\002\000\032" +
    "\004\011\011\016\012\020\013\022\014\012\015\024\016" +
    "\013\021\023\022\010\031\017\032\014\033\015\001\002" +
    "\000\040\002\ufffb\004\011\005\ufffb\006\ufffb\011\016\012" +
    "\020\013\022\014\012\015\024\016\013\021\023\022\010" +
    "\031\017\032\014\033\015\001\002\000\010\002\ufffa\005" +
    "\ufffa\006\ufffa\001\002\000\040\002\ufff4\004\ufff4\005\ufff4" +
    "\006\ufff4\011\ufff4\012\ufff4\013\ufff4\014\ufff4\015\ufff4\016" +
    "\ufff4\021\ufff4\022\ufff4\031\ufff4\032\ufff4\033\ufff4\001\002" +
    "\000\040\002\uffec\004\uffec\005\uffec\006\uffec\011\uffec\012" +
    "\uffec\013\uffec\014\uffec\015\uffec\016\uffec\021\uffec\022\uffec" +
    "\031\uffec\032\uffec\033\uffec\001\002\000\044\002\uffe8\004" +
    "\uffe8\005\uffe8\006\uffe8\007\044\010\043\011\uffe8\012\uffe8" +
    "\013\uffe8\014\uffe8\015\uffe8\016\uffe8\021\uffe8\022\uffe8\031" +
    "\uffe8\032\uffe8\033\uffe8\001\002\000\010\024\027\025\030" +
    "\026\032\001\002\000\040\002\ufff1\004\ufff1\005\ufff1\006" +
    "\ufff1\011\ufff1\012\ufff1\013\ufff1\014\ufff1\015\ufff1\016\ufff1" +
    "\021\ufff1\022\ufff1\031\ufff1\032\ufff1\033\ufff1\001\002\000" +
    "\040\002\ufff0\004\ufff0\005\ufff0\006\ufff0\011\ufff0\012\ufff0" +
    "\013\ufff0\014\ufff0\015\ufff0\016\ufff0\021\ufff0\022\ufff0\031" +
    "\ufff0\032\ufff0\033\ufff0\001\002\000\010\024\027\025\030" +
    "\026\032\001\002\000\040\002\uffef\004\uffef\005\uffef\006" +
    "\uffef\011\uffef\012\uffef\013\uffef\014\uffef\015\uffef\016\uffef" +
    "\021\uffef\022\uffef\031\uffef\032\uffef\033\uffef\001\002\000" +
    "\010\002\001\005\006\006\005\001\002\000\040\002\uffee" +
    "\004\uffee\005\uffee\006\uffee\011\uffee\012\uffee\013\uffee\014" +
    "\uffee\015\uffee\016\uffee\021\uffee\022\uffee\031\uffee\032\uffee" +
    "\033\uffee\001\002\000\040\002\uffe7\004\uffe7\005\uffe7\006" +
    "\uffe7\011\uffe7\012\uffe7\013\uffe7\014\uffe7\015\uffe7\016\uffe7" +
    "\021\uffe7\022\uffe7\031\uffe7\032\uffe7\033\uffe7\001\002\000" +
    "\040\002\uffed\004\uffed\005\uffed\006\uffed\011\uffed\012\uffed" +
    "\013\uffed\014\uffed\015\uffed\016\uffed\021\uffed\022\uffed\031" +
    "\uffed\032\uffed\033\uffed\001\002\000\004\002\uffff\001\002" +
    "\000\040\002\ufff3\004\ufff3\005\ufff3\006\ufff3\011\ufff3\012" +
    "\ufff3\013\ufff3\014\ufff3\015\ufff3\016\ufff3\021\ufff3\022\ufff3" +
    "\031\ufff3\032\ufff3\033\ufff3\001\002\000\010\023\ufff8\024" +
    "\027\030\ufff8\001\002\000\004\023\040\001\002\000\004" +
    "\023\037\001\002\000\004\027\033\001\002\000\004\024" +
    "\027\001\002\000\004\030\035\001\002\000\004\023\036" +
    "\001\002\000\040\002\ufff5\004\ufff5\005\ufff5\006\ufff5\011" +
    "\ufff5\012\ufff5\013\ufff5\014\ufff5\015\ufff5\016\ufff5\021\ufff5" +
    "\022\ufff5\031\ufff5\032\ufff5\033\ufff5\001\002\000\040\002" +
    "\ufff6\004\ufff6\005\ufff6\006\ufff6\011\ufff6\012\ufff6\013\ufff6" +
    "\014\ufff6\015\ufff6\016\ufff6\021\ufff6\022\ufff6\031\ufff6\032" +
    "\ufff6\033\ufff6\001\002\000\040\002\ufff7\004\ufff7\005\ufff7" +
    "\006\ufff7\011\ufff7\012\ufff7\013\ufff7\014\ufff7\015\ufff7\016" +
    "\ufff7\021\ufff7\022\ufff7\031\ufff7\032\ufff7\033\ufff7\001\002" +
    "\000\006\023\ufff9\030\ufff9\001\002\000\040\002\ufff2\004" +
    "\ufff2\005\ufff2\006\ufff2\011\ufff2\012\ufff2\013\ufff2\014\ufff2" +
    "\015\ufff2\016\ufff2\021\ufff2\022\ufff2\031\ufff2\032\ufff2\033" +
    "\ufff2\001\002\000\040\002\uffea\004\uffea\005\uffea\006\uffea" +
    "\011\uffea\012\uffea\013\uffea\014\uffea\015\uffea\016\uffea\021" +
    "\uffea\022\uffea\031\uffea\032\uffea\033\uffea\001\002\000\042" +
    "\002\uffe9\004\uffe9\005\uffe9\006\uffe9\010\045\011\uffe9\012" +
    "\uffe9\013\uffe9\014\uffe9\015\uffe9\016\uffe9\021\uffe9\022\uffe9" +
    "\031\uffe9\032\uffe9\033\uffe9\001\002\000\040\002\uffeb\004" +
    "\uffeb\005\uffeb\006\uffeb\011\uffeb\012\uffeb\013\uffeb\014\uffeb" +
    "\015\uffeb\016\uffeb\021\uffeb\022\uffeb\031\uffeb\032\uffeb\033" +
    "\uffeb\001\002\000\010\002\ufffc\005\ufffc\006\ufffc\001\002" +
    "\000\004\020\053\001\002\000\010\002\ufffe\005\006\006" +
    "\005\001\002\000\010\002\uffe4\005\uffe4\006\uffe4\001\002" +
    "\000\004\002\ufffd\001\002\000\014\002\uffe5\005\uffe5\006" +
    "\uffe5\017\047\022\051\001\002\000\010\002\uffe6\005\uffe6" +
    "\006\uffe6\001\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\053\000\004\002\003\001\001\000\002\001\001\000" +
    "\004\004\047\001\001\000\006\003\020\005\006\001\001" +
    "\000\006\003\045\005\006\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\006\030\007\041\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\006\030\007\025\001\001\000\002\001\001" +
    "\000\004\002\024\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\006\040\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\006\033\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\002\051\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\004\053\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$TemplatingParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$TemplatingParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$TemplatingParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$TemplatingParser$actions {
  private final TemplatingParser parser;

  /** Constructor */
  CUP$TemplatingParser$actions(TemplatingParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$TemplatingParser$do_action(
    int                        CUP$TemplatingParser$act_num,
    java_cup.runtime.lr_parser CUP$TemplatingParser$parser,
    java.util.Stack            CUP$TemplatingParser$stack,
    int                        CUP$TemplatingParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$TemplatingParser$result;

      /* select the action based on the action number */
      switch (CUP$TemplatingParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // map ::= END_DEFINITION_TOKEN 
            {
              MapDefinition RESULT =null;
		 RESULT = new MapDefinition(); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("map",2, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // map ::= MAP_KEY_TOKEN MAP_VALUE_TOKEN 
            {
              MapDefinition RESULT =null;
		int keyleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int keyright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		String key = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		int valleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String val = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new MapDefinition();
                                                         RESULT.map.put(key, val); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("map",2, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // map ::= MAP_KEY_TOKEN MAP_VALUE_TOKEN map 
            {
              MapDefinition RESULT =null;
		int keyleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).left;
		int keyright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).right;
		String key = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).value;
		int valleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int valright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		String val = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		int defleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int defright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		MapDefinition def = (MapDefinition)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 def.map.put(key, val);
                                                         RESULT = def; 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("map",2, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // templatebody ::= GMLID_TOKEN 
            {
              Object RESULT =null;
		 RESULT = new GMLId(); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // templatebody ::= LINK_CALL_TOKEN 
            {
              Object RESULT =null;
		 RESULT = new Link(null); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // templatebody ::= LINK_CALL_TOKEN LINK_PREFIX_TOKEN 
            {
              Object RESULT =null;
		int preleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int preright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String pre = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new Link(pre); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // templatebody ::= LINK_CALL_TOKEN LINK_TEXT_TOKEN 
            {
              Object RESULT =null;
		int textleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int textright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String text = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new Link(null, text); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // templatebody ::= LINK_CALL_TOKEN LINK_PREFIX_TOKEN LINK_TEXT_TOKEN 
            {
              Object RESULT =null;
		int preleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int preright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		String pre = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		int textleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int textright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String text = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new Link(pre, text); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // templatebody ::= VALUE_TOKEN 
            {
              Object RESULT =null;
		 RESULT = new Value(); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // templatebody ::= NAME_TOKEN 
            {
              Object RESULT =null;
		 RESULT = new Name(); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // templatebody ::= INDEX_CALL_TOKEN 
            {
              Object RESULT =null;
		 RESULT = new Index(); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // templatebody ::= ODD_CALL_TOKEN 
            {
              Object RESULT =null;
		int callleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int callright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String call = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new OddEven(call, true); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // templatebody ::= EVEN_CALL_TOKEN 
            {
              Object RESULT =null;
		int callleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int callright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String call = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new OddEven(call, false); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // templatebody ::= MAP_CALL_TOKEN 
            {
              Object RESULT =null;
		int callleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int callright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String[] call = (String[])((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 if(call[0].equalsIgnoreCase("name")) RESULT = new MapCall(call[1], MapCall.Type.Name);
                                                   else RESULT = new MapCall(call[1], MapCall.Type.Value); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // templatebody ::= FEATURE_CALL_TOKEN call 
            {
              Object RESULT =null;
		int callleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int callright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		Triple<String,LinkedList<String>,Boolean> call = (Triple<String,LinkedList<String>,Boolean>)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new FeatureTemplateCall(call.first, call.second, call.third); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // templatebody ::= PROPERTY_CALL_TOKEN call 
            {
              Object RESULT =null;
		int callleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int callright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		Triple<String,LinkedList<String>,Boolean> call = (Triple<String,LinkedList<String>,Boolean>)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new PropertyTemplateCall(call.first, call.second, call.third); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // templatebody ::= TEXT_TOKEN 
            {
              Object RESULT =null;
		int textleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int textright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String text = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = text; 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("templatebody",3, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // call ::= NOT_TOKEN LPAREN_TOKEN names RPAREN_TOKEN TEMPLATE_NAME_TOKEN 
            {
              Triple<String,LinkedList<String>,Boolean> RESULT =null;
		int namesleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).left;
		int namesright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).right;
		LinkedList<String> names = (LinkedList<String>)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new Triple<String, LinkedList<String>, Boolean>(name, names, true); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("call",5, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-4)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // call ::= names TEMPLATE_NAME_TOKEN 
            {
              Triple<String,LinkedList<String>,Boolean> RESULT =null;
		int namesleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int namesright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		LinkedList<String> names = (LinkedList<String>)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new Triple<String, LinkedList<String>, Boolean>(name, names, false); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("call",5, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // call ::= STAR_TOKEN TEMPLATE_NAME_TOKEN 
            {
              Triple<String,LinkedList<String>,Boolean> RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new Triple<String, LinkedList<String>, Boolean>(name, new LinkedList<String>(Collections.singletonList("*")), false); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("call",5, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // names ::= SELECTION_TOKEN 
            {
              LinkedList<String> RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new LinkedList<String>();
                                                   RESULT.add(name); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("names",4, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // names ::= SELECTION_TOKEN names 
            {
              LinkedList<String> RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		int listleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int listright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		LinkedList<String> list = (LinkedList<String>)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 list.add(name);
                                                   RESULT = list; 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("names",4, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // template ::= END_DEFINITION_TOKEN 
            {
              TemplateDefinition RESULT =null;
		 RESULT = new TemplateDefinition(); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("template",1, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // template ::= templatebody 
            {
              TemplateDefinition RESULT =null;
		int objleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int objright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		Object obj = (Object)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new TemplateDefinition();
                                                   RESULT.body.add(obj); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("template",1, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // template ::= templatebody template 
            {
              TemplateDefinition RESULT =null;
		int objleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int objright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		Object obj = (Object)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		int tmplleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int tmplright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		TemplateDefinition tmpl = (TemplateDefinition)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 tmpl.body.add(0, obj);
                                                   RESULT = tmpl; 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("template",1, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // definition ::= MAP_DEFINITION_TOKEN map definition 
            {
              HashMap<String,Definition> RESULT =null;
		int defleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).left;
		int defright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).right;
		String def = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).value;
		int mapleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int mapright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		MapDefinition map = (MapDefinition)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		int defsleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int defsright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		HashMap<String,Definition> defs = (HashMap<String,Definition>)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 map.name = def;
                                                                          defs.put(map.name, map);
                                                                          RESULT = defs; 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("definition",0, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // definition ::= MAP_DEFINITION_TOKEN map 
            {
              HashMap<String,Definition> RESULT =null;
		int defleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int defright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		String def = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		int mapleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int mapright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		MapDefinition map = (MapDefinition)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new HashMap<String, Definition>();
                                                                          map.name = def;
                                                                          RESULT.put(map.name, map); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("definition",0, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // definition ::= TEMPLATE_DEFINITION_TOKEN template definition 
            {
              HashMap<String,Definition> RESULT =null;
		int defleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).left;
		int defright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).right;
		String def = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)).value;
		int tmplleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int tmplright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		TemplateDefinition tmpl = (TemplateDefinition)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		int defsleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int defsright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		HashMap<String,Definition> defs = (HashMap<String,Definition>)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 tmpl.name = def;
                                                                          defs.put(tmpl.name, tmpl);
                                                                          RESULT = defs; 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("definition",0, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-2)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= definition EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		HashMap<String,Definition> start_val = (HashMap<String,Definition>)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		RESULT = start_val;
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$TemplatingParser$parser.done_parsing();
          return CUP$TemplatingParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // definition ::= TEMPLATE_DEFINITION_TOKEN template 
            {
              HashMap<String,Definition> RESULT =null;
		int defleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).left;
		int defright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).right;
		String def = (String)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)).value;
		int tmplleft = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).left;
		int tmplright = ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()).right;
		TemplateDefinition tmpl = (TemplateDefinition)((java_cup.runtime.Symbol) CUP$TemplatingParser$stack.peek()).value;
		 RESULT = new HashMap<String, Definition>();
                                                                          tmpl.name = def;
                                                                          RESULT.put(tmpl.name, tmpl); 
              CUP$TemplatingParser$result = parser.getSymbolFactory().newSymbol("definition",0, ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.elementAt(CUP$TemplatingParser$top-1)), ((java_cup.runtime.Symbol)CUP$TemplatingParser$stack.peek()), RESULT);
            }
          return CUP$TemplatingParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

