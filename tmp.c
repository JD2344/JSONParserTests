uint SrvOs2FeaListSizeToNt(uint *param_1)

{
  longlong lVar1;
  undefined8 uVar2;
  uint *puVar3;
  uint *puVar4;
  uint local_res8 [2];
  
  local_res8[0] = 0;
  puVar3 = param_1 + 1;
  /* THIS LINE HERE. NOTE THE LONGLONG (8 bytes) and declaration of puVar4 as uint (4 bytes).*/
  /* I need to work out if my explanation that when param1 is assigned (shown below)*/
  /* that this line of code is the one that causes the incorrect assignments in length which causes the faulty behaviour*/
  puVar4 = (uint *)((ulonglong)*param_1 + (longlong)param_1);
  while( true ) {
    if (puVar4 <= puVar3) {
      return local_res8[0];
    }
    if (puVar4 <= puVar3 + 1) break;
    lVar1 = (ulonglong)*(byte *)((longlong)puVar3 + 1) +
            (ulonglong)*(ushort *)((longlong)puVar3 + 2);
    if (puVar4 < (uint *)((longlong)puVar3 + lVar1 + 5)) break;
    uVar2 = RtlULongAdd(local_res8[0],
                        *(byte *)((longlong)puVar3 + 1) + 0xc +
                        (uint)*(ushort *)((longlong)puVar3 + 2) & 0xfffffffc,local_res8);
    if ((int)uVar2 < 0) {
      return 0;
    }
    puVar3 = (uint *)((longlong)puVar3 + lVar1 + 5);
  }
  /*THIS LEADS to a buggy return value leading to a buffer overflow.*/
  *(short *)param_1 = (short)puVar3 - (short)param_1;
  return local_res8[0];
}
